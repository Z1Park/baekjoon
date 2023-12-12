import java.util.*;

class Solution {
    
    private long processCount(int n, int[] cores, long time) {
        long cnt = 0;
        for (int core : cores)
            cnt += time / core;
        return cnt;
    }
    
    private long getEndTime(int n, int[] cores) {
        int max = 0;
        for (int core : cores) {
            if (max < core) max = core;
        }
        long start = 0, end = max * cores.length;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (processCount(n, cores, mid) >= n)
                end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
    
    public int solution(int n, int[] cores) {
        if (n <= cores.length) return n;
        n -= cores.length;
        long endTime = getEndTime(n, cores) - 1;
        for (int core : cores)
            n -= endTime / core;
        endTime++;
        for (int i = 0; i < cores.length; i++) {
            if (endTime % cores[i] == 0) {
                if (--n == 0) return i + 1;
            }
        }
        return -1;
    }
}