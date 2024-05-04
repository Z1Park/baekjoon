class Solution {
    
    private int N, M;
    private int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
    private int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
    
    private int getMineCount(char[][] board, int r, int c) {
        int mineCount = 0;
        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                continue;
            if (board[nr][nc] == 'M')
                mineCount++;
        }
        return mineCount;
    }
    
    private void updateBoard(char[][] board, int r, int c) {
        int count = getMineCount(board, r, c);
        if (count == 0) {
            board[r][c] = 'B';
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if (board[nr][nc] == 'E')
                    updateBoard(board, nr, nc);
            }
        }
        else board[r][c] = (char)(count + '0');
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        
        N = board.length;
        M = board[0].length;
        updateBoard(board, r, c);
        return board;
    }
}