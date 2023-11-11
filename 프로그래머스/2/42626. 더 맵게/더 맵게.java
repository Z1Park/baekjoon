import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);
        int cnt = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int least = pq.poll();
            int next = pq.poll();
            pq.add(least + next * 2);
            cnt++;
        }
        if (!pq.isEmpty() && pq.peek() < K) return -1;
        return cnt;
    }
}