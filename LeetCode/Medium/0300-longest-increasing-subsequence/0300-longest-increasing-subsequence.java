class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[2501];
        Arrays.fill(dp, -1);
        
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (dp[j] == -1 || nums[dp[j]] >= nums[i]) {
                    dp[j] = i;
                    maxLength = Math.max(maxLength, j);
                    break;
                }
            }
        }
        return maxLength;
    }
}