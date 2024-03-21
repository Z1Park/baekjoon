class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int maxValue = nums[0];
        if (nums[0] > 0) dp[0][0] = nums[0];
        else dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(nums[i], dp[i-1][0] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i-1][1] * nums[i]);
            }
            else  {
                dp[i][0] = Math.max(nums[i], dp[i-1][1] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i-1][0] * nums[i]);
            }
            if (maxValue < dp[i][0]) maxValue = dp[i][0];
        }
        return maxValue;
    }
}