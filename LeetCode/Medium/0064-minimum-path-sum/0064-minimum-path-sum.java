class Solution {
    
    public int minPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = grid[0][0];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i != R-1)
                    dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + grid[i+1][j]);
                if (j != C-1)
                    dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + grid[i][j+1]);
            }
        }
        return dp[R-1][C-1];
    }
}