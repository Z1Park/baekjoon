class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= 1; j--) {
                if (j < num || dp[j-num] == 0) continue;
                dp[j] = Math.max(dp[j], dp[j-num]+1);
            }
        }
        return dp[target]-1;
    }
}