class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int num : nums) {
            for (int j = target; j >= 1; j--) {
                if (j < num || dp[j-num] == -1) continue;
                dp[j] = Math.max(dp[j], dp[j-num]+1);
            }
        }
        return dp[target];
    }
}