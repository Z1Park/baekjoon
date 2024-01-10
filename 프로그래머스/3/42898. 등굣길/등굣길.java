class Solution {
    
    private static final int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int[] p : puddles) dp[p[1]-1][p[0]-1] = -1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (dp[r][c] == -1) continue;
                int nr = r + 1, nc = c + 1;
                if (nr < n && dp[nr][c] != -1) 
                    dp[nr][c] = (dp[nr][c] + dp[r][c]) % MOD;
                if (nc < m && dp[r][nc] != -1) 
                    dp[r][nc] = (dp[r][nc] + dp[r][c]) % MOD;
            }
        }
        return dp[n-1][m-1];
    }
}