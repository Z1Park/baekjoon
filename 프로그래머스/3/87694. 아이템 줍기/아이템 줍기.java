import java.util.*;

class Solution {
    
    private final int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    private final int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    private final int MAX = 53;
    private boolean[][][] board = new boolean[MAX][MAX][2];
    
    private int bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sx, sy, 0});
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int x = tmp[0], y = tmp[1], cnt = tmp[2];
            if (x == ex && y == ey) return cnt;
            if (board[x][y][0]) {
                board[x][y][0] = false;
                que.add(new int[]{x, y+1, cnt+1});
            }
            if (board[x][y][1]) {
                board[x][y][1] = false;
                que.add(new int[]{x+1, y, cnt+1});
            }
            if (board[x][y - 1][0]) {
                board[x][y - 1][0] = false;
                que.add(new int[]{x, y-1, cnt+1});
            }
            if (board[x - 1][y][1]) {
                board[x - 1][y][1] = false;
                que.add(new int[]{x-1, y, cnt+1});
            }
        }
        return -1;
    }
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1];
            int x2 = rectangle[2], y2 = rectangle[3];
            for (int x = x1; x < x2; x++) {
                board[x][y1][1] = true;
                board[x][y2][1] = true;
            }
            for (int y = y1; y < y2; y++) {
                board[x1][y][0] = true;
                board[x2][y][0] = true;
            }
        }
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1];
            int x2 = rectangle[2], y2 = rectangle[3];
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    if (x != x1) board[x][y][0] = false;
                    if (y != y1) board[x][y][1] = false;
                }
            }
        }
        return bfs(characterX, characterY, itemX, itemY);
    }
}