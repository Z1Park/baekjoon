import java.util.*;
import java.util.stream.*;
import javafx.util.Pair;

class Solution {
    
    private int R, C;
    private final int[] dr = new int[]{0, 1, 0, -1};
    private final int[] dc = new int[]{1, 0, -1, 0};
    private final List<Integer> oilSize = new ArrayList<>();
    
    private void checkBFS(int[][] land, int r, int c, int group) {
        Deque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        land[r][c] = 0;
        int cnt = 0;
        dq.addLast(new Pair(r, c));
        while (!dq.isEmpty()) {
            cnt++;
            Pair<Integer, Integer> p = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nr = p.getKey() + dr[i];
                int nc = p.getValue() + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (land[nr][nc] == 1) {
                    land[nr][nc] = group;
                    dq.addLast(new Pair(nr, nc));
                }
            }
        }
        oilSize.add(cnt);
    }
    
    public int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        int group = 2, maxValue = 0;
        for (int j = 0; j < C; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < R; i++) {
                if (land[i][j] == 1) {
                    set.add(group);
                    checkBFS(land, i, j, group++);
                }
                else if (land[i][j] != 0) {
                    set.add(land[i][j]);
                }
            }
            int sum = 0;
            for (int num : set) sum += oilSize.get(num-2);
            if (sum > maxValue) maxValue = sum;
        }
        return maxValue;
    }
}