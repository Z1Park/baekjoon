import java.util.*;

class Solution {
    
    private int getLongestJump(int[] stones, int term) {
        int maxValue = 0;
        int cnt = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] <= term) {
                if (++cnt > maxValue)
                    maxValue = cnt;
            }
            else cnt = 0;
        }
        return maxValue;
    }
    
    public int solution(int[] stones, int k) {
        int start = 0, end = 200000000;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (getLongestJump(stones, mid) >= k) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}