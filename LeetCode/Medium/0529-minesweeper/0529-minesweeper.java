class Solution {
    
    private int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
    private int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
    
    private int getMineCount(char[][] board, int r, int c) {
        int mineCount = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length)
                continue;
            if (board[nr][nc] == 'M')
                mineCount++;
        }
        return mineCount;
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        
        int count = getMineCount(board, r, c);
        if (count == 0) {
            board[r][c] = 'B';
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length)
                    continue;
                if (board[nr][nc] == 'E') {
                    click[0] = nr;
                    click[1] = nc;
                    updateBoard(board, click);
                }
            }
        }
        else board[r][c] = (char)(count + '0');
        return board;
    }
}