class Solution {
    public int solution(int[][] board, int[][] skill) {
        int R = board.length, C = board[0].length;
        int[][] imos = new int[R+1][C+1];
        for (int[] s : skill) {
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            if (s[0] == 1) degree *= -1;
            imos[r1][c1] += degree;
            imos[r1][c2+1] -= degree;
            imos[r2+1][c1] -= degree;
            imos[r2+1][c2+1] += degree;
        }
        for (int i = 0; i <= R; i++) {
            for (int j = 1; j <= C; j++)
                imos[i][j] += imos[i][j-1];
        }
        for (int j = 0; j <= C; j++) {
            for (int i = 1; i <= R; i++)
                imos[i][j] += imos[i-1][j];
        }
        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] + imos[i][j] > 0)
                    answer++;
            }
        }
        return answer;
    }
}