import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = 
            new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < people.length; i++) {
            pq.add(people[i]);
            rpq.add(people[i]);
        }
        int move = 0;
        int cnt = 0;
        int min = -1, max = -1;
        while (cnt < people.length) {
            move++;
            if (min == -1)
                min = pq.poll();
            max = rpq.poll();
            if (max + min <= limit) {
                cnt++;
                min = -1;
            }
            cnt++;
        }
        return move;
    }
}