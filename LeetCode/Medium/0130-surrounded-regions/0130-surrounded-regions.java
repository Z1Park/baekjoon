class Solution {
    
    private int n, m;
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    private boolean[][] visited;
    
    
    private void makeVisitOnNotSurrounded(char[][] board, int sr, int sc) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int r = tmp[0], c = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc)
                    continue;
                if (board[nr][nc] == 'O' && !visited[nr][nc]) {
                    dq.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
    }
    
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        
        int rEnd = n-1, cEnd = m-1;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                makeVisitOnNotSurrounded(board, i, 0);
            if (board[i][cEnd] == 'O')
                makeVisitOnNotSurrounded(board, i, cEnd);
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O')
                makeVisitOnNotSurrounded(board, 0, i);
            if (board[rEnd][i] == 'O')
                makeVisitOnNotSurrounded(board, rEnd, i);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) board[i][j] = 'X';
            }
        }
    }
}