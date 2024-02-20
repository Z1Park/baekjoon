class Solution {
    
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    
    public int orangesRotting(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 2)
                    dq.add(new int[]{i, j, 0});
            }
        }
        
        int maxValue = 0;
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int r = tmp[0], c = tmp[1], cnt = tmp[2];
            if (cnt > maxValue) maxValue = cnt;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || N <= nr || nc < 0 || M <= nc)
                    continue;
                if (grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    dq.add(new int[]{nr, nc, cnt+1});
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return maxValue;
    }
}