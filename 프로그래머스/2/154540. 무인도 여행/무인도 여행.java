import java.util.*;

class Solution {
    
    private int R, C;
    private int[] dr = {0, 0, 1, -1};
    private int[] dc = {1, -1, 0, 0};
    private char[][] mp;
    
    private int bfs(int sr, int sc) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc});
        int sum = mp[sr][sc] - '0';
        mp[sr][sc] = 'X';
        while (!dq.isEmpty()) {
            int r = dq.peek()[0];
            int c = dq.poll()[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || R <= nr || nc < 0 || C <= nc)
                    continue;
                if (mp[nr][nc] != 'X') {
                    dq.addLast(new int[]{nr, nc});
                    sum += mp[nr][nc] - '0';
                    mp[nr][nc] = 'X';
                }
            }
        }
        return sum;
    }
    
    public int[] solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        mp = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                mp[i][j] = maps[i].charAt(j);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                if (mp[i][j] != 'X') res.add(bfs(i, j));
        }
        if (res.isEmpty()) return new int[]{-1};
        return res.stream().sorted().mapToInt(e -> e).toArray();
    }
}