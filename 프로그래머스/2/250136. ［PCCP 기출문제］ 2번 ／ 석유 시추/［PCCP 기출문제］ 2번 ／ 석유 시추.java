import java.util.*;

class Solution {
    
    private int N, M;
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    private int[] prefix;
    
    private void bfs(int[][] land, int sr, int sc) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sr, sc});
        land[sr][sc] = 0;
        
        int l = M, r = -1, size = 1;
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            if (l > tmp[1]) l = tmp[1];
            if (r < tmp[1]) r = tmp[1];
            for (int i = 0; i < 4; i++) {
                int nr = tmp[0] + dr[i], nc = tmp[1] + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (land[nr][nc] == 1) {
                    land[nr][nc] = 0;
                    que.add(new int[]{nr, nc});
                    size++;
                }
            }
        }
        prefix[l] += size;
        prefix[r+1] -= size;
    }
    
    private int getMaxOil() {
        int maxValue = prefix[0];
        for (int i = 1; i < M; i++) {
            prefix[i] += prefix[i-1];
            if (maxValue < prefix[i]) {
                maxValue = prefix[i];
            }
        }
        return maxValue;
    }
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        prefix = new int[M+1];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1)
                    bfs(land, i, j);
            }
        }
        return getMaxOil();
    }
}