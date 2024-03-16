class Solution {
    public void gameOfLife(int[][] board) {
        int R = board.length, C = board[0].length;
        int[][] nextGen = new int[R][C];
        int[] dr = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dc = {1, 0, -1, 0, 1, -1, 1, -1};
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int liveCount = 0;
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                        continue;
                    liveCount += board[nr][nc];
                }
                if (board[r][c] == 1) {
                    if (2<= liveCount && liveCount <= 3) nextGen[r][c] = 1;
                    else nextGen[r][c] = 0;
                }
                else if (liveCount == 3) nextGen[r][c] = 1;
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++)
                board[r][c] = nextGen[r][c];
        }
    }
}