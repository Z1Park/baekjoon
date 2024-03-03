class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int top = matrix[i][j], right = matrix[j][n-1-i];
                int bottom = matrix[n-1-i][n-1-j], left = matrix[n-1-j][i];
                matrix[i][j] = left;
                matrix[j][n-1-i] = top;
                matrix[n-1-i][n-1-j] = right;
                matrix[n-1-j][i] = bottom;
            }
        }
    }
}