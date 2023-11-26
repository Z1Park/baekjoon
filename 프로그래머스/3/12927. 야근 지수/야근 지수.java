import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) pq.add(w);
        while (n > 0 && pq.peek() != 0) {
            int tmp = pq.poll();
            int gap = tmp - pq.peek();
            if (gap < n) {
                if (tmp - gap == 0) {
                    pq.add(0);
                    n -= gap;
                }
                else {
                    pq.add(tmp - gap - 1);
                    n -= gap + 1;
                }
            }
            else {
                pq.add(tmp - n);
                n = 0;
            }
        }
        long answer = 0;
        while (!pq.isEmpty()) {
            int tmp = pq.poll();
            answer += tmp * tmp;
        }
        return answer;
    }
}