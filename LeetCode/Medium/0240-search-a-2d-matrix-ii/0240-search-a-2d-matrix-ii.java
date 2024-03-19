class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) return false;
        int r = 0, c = 0;
        while (c < matrix[0].length && matrix[r][c] < target)
            c++;
        if (c == matrix[0].length) c--;
        if (matrix[r][c] == target) return true;
        
        int previous = -1;
        while (r < matrix.length && r != previous) {
            previous = r;
            if (matrix[r][c] == target) return true;
            while (c >= 0 && matrix[r][c] > target)
                c--;
            if (c < 0) c = 0;
            if (matrix[r][c] == target) return true;
            while (r < matrix.length && matrix[r][c] < target)
                r++;
        }
        return false;
    }
}