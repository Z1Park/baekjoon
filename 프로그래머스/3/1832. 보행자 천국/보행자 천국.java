import java.util.*;

class Solution {
    
    private final int MOD = 20170805;
    private final int[] dr = {0, 1};
    private final int[] dc = {1, 0};
    
    public int solution(int R, int C, int[][] cityMap) {
        boolean[][][] visit = new boolean[R][C][2];
        int[][][] dp = new int[R][C][2];
        Deque<int[]> dq = new ArrayDeque<>();
        
        visit[0][0][0] = true;
        visit[0][0][1] = true;
        dp[0][0][0] = 1;
        dq.add(new int[]{0, 0, -1});
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int r = tmp[0], c = tmp[1], dir = tmp[2];
            for (int i = 0; i < 2; i++) {
                if (cityMap[r][c] == 2 && dir != i) continue;
                int nr = r + dr[i], nc = c + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    if (cityMap[nr][nc] == 1) continue;
                    if (cityMap[r][c] == 0) {
                        if (cityMap[nr][nc] == 0) {
                            dp[nr][nc][0] = (dp[nr][nc][0] + dp[r][c][0]) % MOD;
                            if (!visit[nr][nc][0]) {
                                visit[nr][nc][0] = true;
                                dq.addLast(new int[]{nr, nc, i});
                            }
                        }
                        else {
                            dp[nr][nc][i] = (dp[nr][nc][i] + dp[r][c][0]) % MOD;
                            if (!visit[nr][nc][i]) {
                                visit[nr][nc][i] = true;
                                dq.addLast(new int[]{nr, nc, i});
                            }
                        }
                    }
                    else if (cityMap[r][c] == 2) {
                        if (cityMap[nr][nc] == 0) {
                            dp[nr][nc][0] = (dp[nr][nc][0] + dp[r][c][i]) % MOD;
                            if (!visit[nr][nc][0]) {
                                visit[nr][nc][0] = true;
                                dq.addLast(new int[]{nr, nc, i});
                            }
                        }
                        else {
                            dp[nr][nc][i] = (dp[nr][nc][i] + dp[r][c][i]) % MOD;
                            if (!visit[nr][nc][i]) {
                                visit[nr][nc][i] = true;
                                dq.addLast(new int[]{nr, nc, i});
                            }
                        }
                    }
                }
            }
        }
        return dp[R-1][C-1][0];
    }
}