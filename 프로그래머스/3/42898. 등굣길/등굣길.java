import java.util.*;

class Solution {
    
    private static final int mod = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        for (int[] p : puddles) dp[p[1]][p[0]] = -1;
        dp[1][1] = 1;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (dp[r][c] == -1) continue;
                int nr = r + 1, nc = c + 1;
                if (nr <= n && dp[nr][c] != -1) {
                    dp[nr][c] += dp[r][c];
                    if (dp[nr][c] > mod) dp[nr][c] %= mod;
                }
                if (nc <= m && dp[r][nc] != -1) {
                    dp[r][nc] += dp[r][c];
                    if (dp[r][nc] > mod) dp[r][nc] %= mod;
                }
            }
        }
        return dp[n][m];
    }
}