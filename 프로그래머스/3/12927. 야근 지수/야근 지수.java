import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) pq.add(w);
        while (n > 0 && pq.peek() != 0) {
            int currWork = pq.poll();
            int gap = currWork - pq.peek();
            if (gap >= n) gap = n;
            else if (currWork - gap > 0) gap++;
            pq.add(currWork - gap);
            n -= gap;
        }
        long sum = 0;
        while (!pq.isEmpty()) {
            int tmp = pq.poll();
            sum += tmp * tmp;
        }
        return sum;
    }
}