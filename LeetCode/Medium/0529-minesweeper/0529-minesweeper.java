class Solution {
    
    private int N, M;
    private int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
    private int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
    
    private int[][] getCountBoard(char[][] board) {
        int[][] countBoard = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] != 'M') continue;
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;
                    countBoard[nr][nc]++;
                }
            }
        }
        return countBoard;
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        N = board.length;
        M = board[0].length;
        int[][] countBoard = getCountBoard(board);
        
        Queue<int[]> que = new LinkedList<>();
        que.add(click);
        board[click[0]][click[1]] = (countBoard[click[0]][click[1]] == 0 ? 'B' : (char)(countBoard[click[0]][click[1]] + '0'));
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int r = tmp[0], c = tmp[1];
            if (countBoard[r][c] == 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;
                    if (board[nr][nc] == 'E') {
                        if (countBoard[nr][nc] == 0) {
                            board[nr][nc] = 'B';
                            que.add(new int[]{nr, nc});
                        }
                        else board[nr][nc] = (char)(countBoard[nr][nc] + '0');
                    }
                }
            }
        }
        return board;
    }
}