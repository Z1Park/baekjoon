import java.util.*;

class Solution {
    
    int R, C;
    int[] dr = new int[]{0, 1, 0, -1};
    int[] dc = new int[]{1, 0, -1, 0};
    
    private class Data {
        private int row;
        private int col;
        private int count;

        private Data(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        Deque<Data> dq = new ArrayDeque<>();
        dq.addLast(new Data(0, 0, 1));
        while (dq.size() != 0) {
            Data tmp = dq.pollFirst();
            if (tmp.row == R-1 && tmp.col == C-1)
                return tmp.count;
            for (int i = 0; i < 4; i++) {
                int nr = tmp.row + dr[i];
                int nc = tmp.col + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C 
                    && maps[nr][nc] == 1) {
                    maps[nr][nc] = 0;
                    dq.addLast(new Data(nr, nc, tmp.count+1));
                }
            }
        }
        return -1;
    }
}