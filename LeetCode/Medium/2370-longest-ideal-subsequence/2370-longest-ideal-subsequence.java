class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'a';
            int low = Math.max(curr - k, 0), high = Math.min(curr + k, 25);
            
            int maxValue = 0;
            for (int j = low; j <= high; j++) {
                if (maxValue <= dp[j])
                    maxValue = dp[j] + 1;
            }
            if (dp[curr] < maxValue) dp[curr] = maxValue;
            if (result < dp[curr]) result = dp[curr];
        }
        return result;
    }
}