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
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        N = board.length;
        M = board[0].length;
        
        int mineCount = getMineCount(board, click[0], click[1]);
        if (mineCount == 0) board[click[0]][click[1]] = 'B';
        else board[click[0]][click[1]] = (char)(mineCount + '0');
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{click[0], click[1], mineCount});
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int r = tmp[0], c = tmp[1], count = tmp[2];
            
            if (count == 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                        continue;
                    if (board[nr][nc] == 'E') {
                        int next = getMineCount(board, nr, nc);
                        if (next == 0) {
                            board[nr][nc] = 'B';
                            que.add(new int[]{nr, nc, next});
                        }
                        else board[nr][nc] = (char)(next + '0');
                    }
                }
            }
        }
        return board;
    }
}