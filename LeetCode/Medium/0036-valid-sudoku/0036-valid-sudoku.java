class Solution {
    
    private boolean checkRowValid(char[][] board, int c) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == '.') continue;
            int t = board[i][c] - '0';
            if (check[t]) return false;
            check[t] = true;
        }
        return true;
    }
    
    private boolean checkColumnValid(char[][] board, int r) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == '.') continue;
            int t = board[r][i] - '0';
            if (check[t]) return false;
            check[t] = true;
        }
        return true;
    }
    
    private boolean checkAreaValid(char[][] board, int r, int c) {
        boolean[] check = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[r+i][c+j] == '.') continue;
                int t = board[r+i][c+j] - '0';
                if (check[t]) return false;
                check[t] = true;
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRowValid(board, i)) return false;
            if (!checkColumnValid(board, i)) return false;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkAreaValid(board, i*3, j*3))
                    return false;
            }
        }
        return true;
    }
}