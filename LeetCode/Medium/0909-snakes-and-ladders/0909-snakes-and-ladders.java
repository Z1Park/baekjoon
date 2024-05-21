class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length, ref = (N - 1) % 2, last = N * N - 1;
        boolean[][] visit = new boolean[N][N];
        
        Queue<int[]> que = new LinkedList<>();
        visit[N-1][0] = true;
        que.add(new int[]{1, 0});
        while (!que.isEmpty()) {
            int[] tmp = que.poll();
            int idx = tmp[0], move = tmp[1];
            if (idx == last + 1) return move;
            for (int i = 1; i <= 6; i++) {
                int diceIdx = idx + i - 1;
                if (diceIdx > last) break;
                int nr = N - diceIdx / N - 1;
                int nc = nr % 2 == ref ? diceIdx % N : N - 1 - diceIdx % N;
                if (board[nr][nc] != -1) {
                    diceIdx = board[nr][nc] - 1;
                    nr = N - diceIdx / N - 1;
                    nc = nr % 2 == ref ? diceIdx % N : N - 1 - diceIdx % N;
                }
                if (!visit[nr][nc]) {
                    visit[nr][nc] = true;
                    que.add(new int[]{diceIdx + 1, move + 1});
                }
            }
        }
        return -1;
    }
}