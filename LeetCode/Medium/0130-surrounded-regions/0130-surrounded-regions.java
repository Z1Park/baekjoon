class Solution {
    
    private int n, m;
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    private boolean[][] visited;
    
    
    private void checkSurroundedAndFlip(char[][] board, int sr, int sc) {
        Deque<int[]> dq = new ArrayDeque<>();
        Set<int[]> check = new HashSet<>();
        
        int[] start = new int[]{sr, sc};
        boolean flag = true;
        dq.add(start);
        check.add(start);
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int r = tmp[0], c = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc)
                    continue;
                int[] next = new int[]{nr, nc};
                if (board[nr][nc] == 'O' && !visited[nr][nc]) {
                    dq.add(next);
                    check.add(next);
                    visited[nr][nc] = true;
                    if (nr == 0 || nc == 0 || nr == n-1 || nc == m-1)
                        flag = false;
                }
            }
        }
        
        if (flag) {
            for (int[] e : check)
                board[e[0]][e[1]] = 'X';
        }
    }
    
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    checkSurroundedAndFlip(board, i, j);
            }
        }
    }
}