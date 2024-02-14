import java.util.*;

class Solution {
    
    private int[] dr = {0, 1, 0, -1};
    private int[] dc = {1, 0, -1, 0};
    private int N;
    private int[][] game_board, table;
    private List<int[][]> blankList = new ArrayList<>();
    private List<int[][]> blockList = new ArrayList<>();
    
    private List<int[]> getBlock(int sr, int sc) {
        int[] minValue = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        List<int[]> res = new ArrayList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc});
        table[sr][sc] = 0;
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            res.add(tmp);
            int r = tmp[0], c = tmp[1];
            if (minValue[0] > r) minValue[0] = r;
            if (minValue[1] > c) minValue[1] = c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;
                if (table[nr][nc] == 1) {
                    table[nr][nc] = 0;
                    dq.add(new int[]{nr, nc});
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            int[] tmp = res.get(i);
            tmp[0] -= minValue[0];
            tmp[1] -= minValue[1];
            res.set(i, tmp);
        }
        return res;
    }
    
    private List<int[]> getBlank(int sr, int sc) {
        int[] minValue = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        List<int[]> res = new ArrayList<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc});
        game_board[sr][sc] = 1;
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            res.add(tmp);
            int r = tmp[0], c = tmp[1];
            if (minValue[0] > r) minValue[0] = r;
            if (minValue[1] > c) minValue[1] = c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr < 0 || N <= nr || nc < 0 || N <= nc)
                    continue;
                if (game_board[nr][nc] == 0) {
                    game_board[nr][nc] = 1;
                    dq.add(new int[]{nr, nc});
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            int[] tmp = res.get(i);
            tmp[0] -= minValue[0];
            tmp[1] -= minValue[1];
            res.set(i, tmp);
        }
        return res;
    }
    
    private int[][] makeArray(List<int[]> block) {
        int R = 0, C = 0;
        for (int[] b : block) {
            if (R < b[0]) R = b[0];
            if (C < b[1]) C = b[1];
        }
        int[][] arr = new int[++R][++C];
        for (int[] b : block)
            arr[b[0]][b[1]] = 1;
        return arr;
    }
    
    private int[][] rotateBlock(int[][] block) {
        int R = block.length, C = block[0].length;
        int[][] arr = new int[C][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                arr[j][R-1-i] = block[i][j];
        }
        return arr;
    }
    
    public boolean isTwoBlockSame(int[][] block1, int[][] block2) {
        for (int i = 0; i < block1.length; i++) {
            for (int j = 0; j < block1[0].length; j++) {
                if (block1[i][j] != block2[i][j])
                    return false;
            }
        }
        return true;
    }
    
    public boolean findMatch(int[][] block) {
        for (int i = 0; i < 4; i++) {
            block = rotateBlock(block);
            for (int j = blankList.size()-1; j >= 0; j--) {
                if (blankList.get(j).length != block.length) continue;
                if (blankList.get(j)[0].length != block[0].length) continue;
                if (isTwoBlockSame(block, blankList.get(j))) {
                    blankList.remove(j);
                    return true;
                }
            }
        }
        return false;
    }
    
    private int getCount(int[][] block) {
        int cnt = 0;
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[0].length; j++)
                cnt += block[i][j];
        }
        return cnt;
    }
    
    public int solution(int[][] g, int[][] t) {
        game_board = g;
        table = t;
        N = game_board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0) {
                    List<int[]> blank = getBlank(i, j);
                    blankList.add(makeArray(blank));
                }
                if (table[i][j] == 1) {
                    List<int[]> block = getBlock(i, j);
                    blockList.add(makeArray(block));
                }
            }
        }
        int cnt = 0;
        for (int[][] block : blockList) {
            if (findMatch(block))
                cnt += getCount(block);
        }
        return cnt;
    }
}