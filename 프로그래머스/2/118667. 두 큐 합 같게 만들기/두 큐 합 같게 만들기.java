import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new ArrayDeque<>();
        Arrays.stream(queue1).forEach(e -> que1.add(e));
        Queue<Integer> que2 = new ArrayDeque<>();
        Arrays.stream(queue2).forEach(e -> que2.add(e));
        long sum1 = Arrays.stream(queue1).reduce((a, b) -> a + b).orElse(0);
        long sum2 = Arrays.stream(queue2).reduce((a, b) -> a + b).orElse(0);
        int cnt = 0, max = (que1.size() + que2.size()) * 4;
        while (sum1 != sum2) {
            if (sum1 > sum2) {
                if (que1.isEmpty()) return -1;
                que2.add(que1.peek());
                sum1 -= que1.peek();
                sum2 += que1.poll();
            }
            else {
                if (que2.isEmpty()) return -1;
                que1.add(que2.peek());
                sum1 += que2.peek();
                sum2 -= que2.poll();
            }
            cnt++;
            if (cnt > max) return -1;
        }
        return cnt;
    }
}