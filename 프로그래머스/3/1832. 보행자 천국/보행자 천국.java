import java.util.*;

class Solution {
    
    private final int MOD = 20170805;
    private final int[] dr = {0, 1};
    private final int[] dc = {1, 0};
    
    public int solution(int R, int C, int[][] cityMap) {
        boolean[][] visit = new boolean[R][C];
        int[][] dp = new int[R][C];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing(arr -> arr[3]));
        
        visit[0][0] = true;
        dp[0][0] = 1;
        pq.add(new int[]{0, 0, -1, 0});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int r = tmp[0], c = tmp[1], dir = tmp[2];
            for (int i = 0; i < 2; i++) {
                int cnt = tmp[3];
                int nr = r + dr[i], nc = c + dc[i];
                while (0 <= nr && nr < R && 0 <= nc && nc < C && cityMap[nr][nc] == 2) {
                    nr += dr[i];
                    nc += dc[i];
                    cnt++;
                }
                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
                if (cityMap[nr][nc] == 1) continue;
                dp[nr][nc] = (dp[nr][nc] + dp[r][c]) % MOD;
                if (!visit[nr][nc]) {
                    visit[nr][nc] = true;
                    pq.add(new int[]{nr, nc, i, cnt+1});
                }
            }
        }
        return dp[R-1][C-1];
    }
}