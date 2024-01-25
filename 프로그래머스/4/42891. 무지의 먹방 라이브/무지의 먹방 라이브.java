import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing(a -> a[0]));
        for (int i = 0; i < food_times.length; i++)
            pq.add(new int[]{food_times[i], i});
        long acc = 0;
        long rotate;
        while (k > 0 && !pq.isEmpty()) {
            long min = pq.peek()[0];
            rotate = (min - acc) * pq.size();
            if (rotate <= k) {
                acc = min;
                food_times[pq.poll()[1]] = 0;
                k -= rotate;
            }
            else break;
        }
        if (pq.isEmpty()) return -1;
        rotate = k / pq.size();
        k -= rotate * pq.size();
        rotate += acc;
        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] == 0) continue;
            food_times[i] -= rotate;
            if (food_times[i] > 0) {
                if (k > 0) {
                    food_times[i] -= 1;
                    k--;
                }
                else return i+1;
            }
        }
        return -1;
    }
}