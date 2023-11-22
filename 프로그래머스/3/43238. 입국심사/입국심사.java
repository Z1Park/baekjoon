import java.util.*;

class Solution {
    
    private long getCount(int[] times, long curr) {
        long count = 0;
        for (int time : times)
            count += curr / (long)time;
        return count;
    }
    
    public long solution(int n, int[] times) {
        int max = Arrays.stream(times).max().getAsInt();
        long start = 0, end = (long)max * n;
        while (start <= end) {
            long mid = (start / 2 + end / 2) + 
                ((start % 2 == 1 && end % 2 == 1) ? 1 : 0);
            if (getCount(times, mid) < n)
                start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}