import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);
        int cnt = 0;
        while (pq.size() > 1) {
            if (pq.peek() >= K) return cnt;
            pq.add(pq.poll() + pq.poll() * 2);
            cnt++;
        }
        if (pq.size() == 1 && pq.peek() >= K) return cnt;
        return -1;
    }
}