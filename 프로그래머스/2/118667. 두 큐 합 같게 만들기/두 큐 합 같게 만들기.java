import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> que1 = new ArrayDeque<>();
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            que1.add(queue1[i]);
        }
        Queue<Integer> que2 = new ArrayDeque<>();
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            que2.add(queue2[i]);
        }
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