import java.util.*;

class Solution {

    private static int max = 1000000000;

    private int calculateEatingHour(int[] piles, int k) {
        int cnt = 0;
        for (int pile : piles) cnt += Math.ceil((double)pile / k);
        return cnt;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = max;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (calculateEatingHour(piles, mid) <= h)
                end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}