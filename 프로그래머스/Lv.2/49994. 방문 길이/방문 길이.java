class Solution {
    
    private final int R = 11, C = 11;
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    private int[] pos = {5, 5};
    private boolean[][][] visit = new boolean[R][C][2];
    
    private boolean visitCheck(int r, int c, int d) {
        if (visit[r][c][d%2]) return false;
        visit[r][c][d%2] = true;
        return true;
    }
    
    private boolean move(char d) {
        int dir = "RDLU".indexOf(d);
        int r = pos[0], c = pos[1];
        int nr = r + dr[dir], nc = c + dc[dir];
        if (nr < 0 || R <= nr || nc < 0 || C <= nc)
            return false;
        pos[0] = nr;
        pos[1] = nc;
        if (dir / 2 == 0) return visitCheck(nr, nc, dir);
        return visitCheck(r, c, dir);
    }
    
    public int solution(String dirs) {
        int cnt = 0;
        for (char d : dirs.toCharArray())
            if (move(d)) cnt++;
        return cnt;
    }
}