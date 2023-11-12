import java.util.*;
import java.util.stream.*;

class Solution {
    
    private int r = 0;
    private int c = 0;
    private final int dr[] = new int[]{-1, 1, 0, 0};
    private final int dc[] = new int[]{0, 0, -1, 1};
    private boolean[][][] visit = new boolean[11][11][2];
    
    public int solution(String dirs) {
        int cnt = 0;
        for (char d : dirs.toCharArray()) {
            int dir = "UDLR".indexOf(d);
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < -5 || nr > 5 || nc < -5 || nc > 5) continue;
            if (dir % 2 == 0) {
                if (!visit[nr+5][nc+5][dir/2]) {
                    cnt++;
                    visit[nr+5][nc+5][dir/2] = true;
                }
            }
            else {
                if (!visit[r+5][c+5][dir/2]) {
                    cnt++;
                    visit[r+5][c+5][dir/2] = true;
                }
            }
            r = nr;
            c = nc;
        }
        return cnt;
    }
}