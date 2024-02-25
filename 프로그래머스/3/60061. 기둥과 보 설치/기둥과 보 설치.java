import java.util.*;

class Solution {
    
    private int[] dr = {0, 0, 1, 0, -1, 1, 1, -1, -1};
    private int[] dc = {0, 1, 0, -1, 0, 1, -1, 1, -1};
    
    
    private boolean bitAnd(int A, int bit) {
        if ((A & bit) == bit) return true;
        return false;
    }
    
    private boolean checkColumnConstruct(int[][] area, int r, int c) {
        if (r == 0) return true;
        if (bitAnd(area[r-1][c], 1)) return true;
        if (c > 0 && bitAnd(area[r][c-1], 2)) return true;
        return false;
    }
    
    private boolean checkFlooringConstruct(int[][] area, int r, int c) {
        if (r == 0) return false;
        if (bitAnd(area[r-1][c], 1)) return true;
        if (bitAnd(area[r-1][c+1], 1)) return true;
        if (c > 0 && bitAnd(area[r][c-1], 2) && bitAnd(area[r][c+1], 2))
            return true;
        return false;
    }
    
    private boolean checkPossible(int[][] area, int n, int r, int c) {
        for (int i = 0; i < 9; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr < 0 || n < nr || nc < 0 || n < nc || area[nr][nc] == 0) continue;
            boolean flag = true;
            if (bitAnd(area[nr][nc], 1))
                flag = checkColumnConstruct(area, nr, nc);
            if (bitAnd(area[nr][nc], 2))
                flag = checkFlooringConstruct(area, nr, nc);
            if (!flag) return false;
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] area = new int[n+1][n+1];
        
        for (int[] frame : build_frame) {
            int c = frame[0], r = frame[1];
            if (frame[3] == 0) {
                int tmp = area[r][c];
                area[r][c] &= ~(frame[2] + 1);
                if (!checkPossible(area, n, r, c))
                    area[r][c] = tmp;
            }
            else {
                int tmp = area[r][c];
                area[r][c] |= frame[2] + 1;
                if (!checkPossible(area, n, r, c))
                    area[r][c] = tmp;
            }
        }
        
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (bitAnd(area[i][j], 1))
                    res.add(new int[]{j, i, 0});
                if (bitAnd(area[i][j], 2))
                    res.add(new int[]{j, i, 1});
            }
        }
        return res.stream()
            .sorted(Comparator.comparing((int[] arr) -> arr[0])
                   .thenComparing((int[] arr) -> arr[1])
                   .thenComparing((int[] arr) -> arr[2]))
            .toArray(int[][]::new);
    }
}