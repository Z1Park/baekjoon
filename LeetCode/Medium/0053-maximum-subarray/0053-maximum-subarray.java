class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i+1] = (dp[i] < 0 ? 0 : dp[i]) + nums[i];
            max = Math.max(dp[i+1], max);
        }
        return max;
    }
}