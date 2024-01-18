/*
1. n-2 까지 채워져 있고 중복 없이 2 x 3 을 채우는 방법
11  11  12
22  23  12
33  23  33

2. n-4 까지 채워져 있고 중복 없이 4 x 3 을 채우는 방법
1122  1223
3446  1443
3556  5566

3. n-6 까지 채워져 있고 중복 없이 6 x 3 을 채우는 방법
=> n-4 중간에 가로로 끼워 넣기
11--22  1--223
3--446  1--443
3--556  55--66

4. n-8 => n-6과 동일


=> dp[n] = dp[n-2] * 3 + dp[n-4] * 2 + dp[n-6] * 2 + ...
=> dp[n-2] = dp[n-4] * 3 + dp[n-6] * 2 + ...
=> dp[n] = dp[n-2] * 3 + dp[n-2] - dp[n-4] = dp[n-2] * 4 - dp[n-4]

*/


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