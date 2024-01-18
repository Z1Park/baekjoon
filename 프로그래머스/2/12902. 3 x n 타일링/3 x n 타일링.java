class Solution {
    public int solution(int n) {
        if (n % 2 != 0) return 0;
        if (n == 2) return 3;
        final int MOD = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i++)
            dp[i] = (dp[i-2] * 4 - dp[i-4] + MOD) % MOD;
        return (int)dp[n];
    }
}