import java.util.*;

class Solution {
    
    private static final int MAX = 1000000;
    
    public int solution(int[][] board) {
        int R = board.length, C = board[0].length;
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        int[][][] dp = new int[R][C][4];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j< C; j++) {
                if (i == 0 && j == 0) continue;
                for (int k = 0; k < 4; k++)
                    dp[i][j][k] = MAX;
            }
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, 0, -1});
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int r = tmp[0], c = tmp[1], cost = tmp[2], dir = tmp[3];
            if ((dir != -1 && dp[r][c][dir] < cost) || (r == R-1 && c == C-1))
                continue;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
                int newCost = cost + 100;
                if (dir != i && dir != -1) newCost += 500;
                if (dp[nr][nc][i] >= newCost && board[nr][nc] == 0) {
                    que.add(new int[]{nr, nc, newCost, i});
                    dp[nr][nc][i] = newCost;
                }
            }
        }
        int res = MAX;
        for (int i = 0; i < 4; i++)
            res = Math.min(res, dp[R-1][C-1][i]);
        return res;
    }
}