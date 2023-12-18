import java.util.*;

class Solution {
    
    private int R, C, sr, sc;
    private int[] dr = new int[]{0, 1, 0, -1};
    private int[] dc = new int[]{1, 0, -1, 0};
    private char[][] arr;
    
    private void setArr(String[] maps, char target) {
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] = maps[i].charAt(j);
                if (arr[i][j] == target) {
                    sr = i;
                    sc = j;
                }
            }
        }
    }
    
    private int bfs(char target) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc, 0});
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int r = curr[0], c = curr[1], cnt = curr[2];
            if (arr[r][c] == target) return cnt;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (arr[nr][nc] != 'X') {
                        if (arr[nr][nc] != target)
                            arr[nr][nc] = 'X';
                        dq.addLast(new int[]{nr, nc, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        setArr(maps, 'S');
        int cnt1 = bfs('L');
        if (cnt1 == -1) return -1;
        setArr(maps, 'L');
        int cnt2 = bfs('E');
        if (cnt2 == -1) return -1;
        return cnt1 + cnt2;
    }
}