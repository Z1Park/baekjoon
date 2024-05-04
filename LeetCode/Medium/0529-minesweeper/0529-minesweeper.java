class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int N = board.length, M = board[0].length;
        int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
        boolean[][] visit = new boolean[N][M];
        
        Queue<int[]> que = new LinkedList<>();
        que.add(click);
        visit[click[0]][click[1]] = true;
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int r = tmp[0], c = tmp[1];
            
            if (board[r][c] == 'M') {
                board[r][c] = 'X';
                continue;
            }
            
            int mineCount = 0;
            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if (board[nr][nc] == 'M')
                    mineCount++;
            }
            if (mineCount == 0) {
                board[r][c] = 'B';
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;
                    if (!visit[nr][nc] && board[nr][nc] == 'E') {
                        visit[nr][nc] = true;
                        que.add(new int[]{nr, nc});
                    }
                }
            }
            else board[r][c] = (char)(mineCount + '0');
        }
        return board;
    }
}