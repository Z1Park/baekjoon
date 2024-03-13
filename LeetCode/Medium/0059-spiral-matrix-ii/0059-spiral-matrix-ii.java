class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int R = n, C = n, r = 0, c = -1;
        int idx = 0;
        while (R > 0 && C > 0) {
            for (int i = 0; i < C; i++)
                matrix[r][++c] = ++idx;
            if (--R <= 0) break;
            
            for (int i = 0; i < R; i++)
                matrix[++r][c] = ++idx;
            if (--C <= 0) break;
            
            for (int i = 0; i < C; i++)
                matrix[r][--c] = ++idx;
            if (--R <= 0) break;
            
            for (int i = 0; i < R; i++)
                matrix[--r][c] = ++idx;
            C--;
        }
        return matrix;
    }
}