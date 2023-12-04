import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            if (pq.size() < k) pq.add(enemy[i]);
            else {
                pq.add(enemy[i]);
                int curr = pq.poll();
                if (n >= curr) n -= curr;
                else return i;
            }
        }
        return enemy.length;
    }
}