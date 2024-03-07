class Solution {
    
    private int reverseDFS(int r, int c, int[][] grid, int[][] dp) {
        if (r == 0 && c == 0) return grid[0][0];
        if (r < 0 || c < 0) return Integer.MAX_VALUE;
        if (dp[r][c] != 0) return dp[r][c];
        int left = reverseDFS(r, c-1, grid, dp);
        int up = reverseDFS(r-1, c, grid, dp);
        dp[r][c] = grid[r][c] + Math.min(left, up);
        return dp[r][c];
    }
    
    public int minPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dp = new int[R][C];
        return reverseDFS(R-1, C-1, grid, dp);
    }
}