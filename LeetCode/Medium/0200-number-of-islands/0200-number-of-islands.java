class Solution {
    
    private final int[] dr = {1, 0, -1, 0};
    private final int[] dc = {0, 1, 0, -1};
    
    private void countIsland(char[][] grid, int sr, int sc) {
        int n = grid.length, m = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc});
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int r = tmp[0], c = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || n <= nr || nc < 0 || m <= nc)
                    continue;
                if (grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    dq.add(new int[]{nr, nc});
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    countIsland(grid, i, j);
                }
            }
        }
        return count;
    }
}