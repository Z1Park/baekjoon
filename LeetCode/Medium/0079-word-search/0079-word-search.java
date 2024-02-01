class Solution {
    
    int R, C;
    boolean[][] visit;
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    
    private boolean dfs(char[][] board, String word, int r, int c, int depth) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                continue;
            if (word.charAt(depth) == board[nr][nc] && !visit[nr][nc]) {
                visit[nr][nc] = true;
                if (depth + 1 == word.length() || 
                    dfs(board, word, nr, nc, depth + 1))
                    return true;
                visit[nr][nc] = false;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = board[0].length;
        visit = new boolean[R][C];
        char c = word.charAt(0);
        for (int i = 0 ; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != c) continue;
                if (word.length() == 1) return true;
                visit[i][j] =  true;
                if (dfs(board, word, i, j, 1))
                    return true;
                visit[i][j] = false;
            }
        }
        return false;
    }
}