import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] times = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = Integer.parseInt(book_time[i][0].substring(0, 2)) 
                * 60 + Integer.parseInt(book_time[i][0].substring(3, 5));
            times[i][1] = Integer.parseInt(book_time[i][1].substring(0, 2)) 
                * 60 + Integer.parseInt(book_time[i][1].substring(3, 5)) + 10;
        }
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(times[0][1]);
        for (int i = 1; i < times.length; i++) {
            if (pq.peek() <= times[i][0]) pq.poll();
            pq.add(times[i][1]);
        }
        return pq.size();
    }
}