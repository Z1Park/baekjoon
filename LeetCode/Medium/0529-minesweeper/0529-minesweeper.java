class Solution {
    
    private int N, M;
    
    private int[][] getCountBoard(char[][] board) {
        int[][] prefix = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                prefix[i+1][j+1] = prefix[i+1][j] + prefix[i][j+1] - prefix[i][j] + (board[i][j] == 'M' ? 1 : 0);
            }
        }
        
        int[][] countBoard = new int[N][M];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (board[i-1][j-1] == 'M') continue;
                int top = Math.max(0, i-2), left = Math.max(0, j-2);
                int bottom = Math.min(N, i+1), right = Math.min(M, j+1);
                countBoard[i-1][j-1] = prefix[bottom][right] - prefix[bottom][left] - prefix[top][right] + prefix[top][left];
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
        int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
        int[][] countBoard = getCountBoard(board);
        boolean[][] visit = new boolean[N][M];
        
        Queue<int[]> que = new LinkedList<>();
        que.add(click);
        visit[click[0]][click[1]] = true;
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