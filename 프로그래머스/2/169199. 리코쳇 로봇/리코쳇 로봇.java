import java.util.*;

class Solution {
    
    private int R, C;
    private char[][] board;
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    
    private int[] move(int r, int c, int d) {
        int nr = r + dr[d], nc = c + dc[d];
        while (0 <= nr && nr < R && 0 <= nc && nc < C && board[nr][nc] != 'D') {
            r = nr;
            c = nc;
            nr += dr[d];
            nc += dc[d];
        }
        return new int[]{r, c};
    }
    
    private int bfs(int sr, int sc) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sr, sc, 0});
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int r = tmp[0], c = tmp[1], cnt = tmp[2];
            if (board[r][c] == 'G') return cnt;
            for (int i = 0; i < 4; i++) {
                int[] next = move(r, c, i);
                int nr = next[0], nc = next[1];
                if ((nr == r && nc == c) || board[nr][nc] == 'X') continue;
                if (board[nr][nc] != 'G') board[nr][nc] = 'X';
                que.add(new int[]{nr, nc, cnt+1});
            }
        }
        return -1;
    }
    
    public int solution(String[] b) {
        R = b.length;
        C = b[0].length();
        board = new char[R][C];
        int r = -1, c = -1;
        for (int i = 0; i < R; i++) {
            board[i] = b[i].toCharArray();
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                }
            }
        }
        board[r][c] = 'X';
        return bfs(r, c);
    }
}