class Solution {
    public int minimumAverageDifference(int[] nums) {
        int len = nums.length;
        long lsum = 0, rsum = 0;
        for (int i = 0; i < len; i++)
            rsum += nums[i];
        
        int idx = -1, minValue = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            lsum += nums[i-1];
            rsum -= nums[i-1];
            int diff = Math.abs((int)((lsum / i) - (i == len ? 0 : rsum / (len - i))));
            if (minValue > diff) {
                minValue = diff;
                idx = i-1;
            }
        }
        return idx;
    }
}