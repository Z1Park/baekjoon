class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length, r = 0, c = -1;
        List<Integer> result = new ArrayList<>();
        while (R > 0 && C > 0) {
            for (int i = 0; i < C; i++)
                result.add(matrix[r][++c]);
            R--;
            if (R <= 0) break;
            
            for (int i = 0; i < R; i++)
                result.add(matrix[++r][c]);
            C--;
            if (C <= 0) break;
            
            for (int i = 0; i < C; i++)
                result.add(matrix[r][--c]);
            R--;
            if (R <= 0) break;
            
            for (int i = 0; i < R; i++)
                result.add(matrix[--r][c]);
            C--;
        }
        return result;
    }
}