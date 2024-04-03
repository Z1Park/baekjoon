class Solution {
    
    private int N, M;
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    private boolean[][] used;
    
    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx >= word.length()) return true;
        used[r][c] = true;
        
        char cc = word.charAt(idx);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                continue;
            
            if (board[nr][nc] == cc && !used[nr][nc] 
                && dfs(board, word, nr, nc, idx+1)) {
                return true;
            }
        }
        used[r][c] = false;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        used = new boolean[N][M];
        
        char c = word.charAt(0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == c && dfs(board, word, i, j, 1))
                    return true;
            }
        }
        return false;
    }
}