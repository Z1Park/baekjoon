import java.util.*;
import java.io.*;


class Solution {

	private final int N, M, K;
	private final int[] dr = {0, 1, 0, -1};
	private final int[] dc = {1, 0, -1, 0};
	private final int[][] board;
	private final int[][] dice = {{0, 2, 0}, {4, 1, 3}, {0, 5, 0}, {0, 6, 0}};


	public Solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] vars = br.readLine().split(" ");
		N = Integer.parseInt(vars[0]);
		M = Integer.parseInt(vars[1]);
		K = Integer.parseInt(vars[2]);

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++)
				board[i][j] = Integer.parseInt(tmp[j]);
		}
	}

	private void rotateDice(int d) {
		if (d == 0) {
			int tmp = dice[1][2];
			dice[1][2] = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = tmp;
		}
		else if (d == 1) {
			int tmp = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = tmp;
		}
		else if (d == 2) {
			int tmp = dice[1][0];
			dice[1][0] = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = tmp;
		}
		else {
			int tmp = dice[0][1];
			dice[0][1] = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = tmp;
		}
	}

	private int getNextDirection(int r, int c, int d) {
		int A = dice[3][1], B = board[r][c], dir;
		if (A > B) dir = (d + 1) % 4;
		else if (A < B) dir = (d + 3) % 4;
		else dir = d;

		int nr = r + dr[dir], nc = c + dc[dir];
		if (nr < 0 || N <= nr || nc < 0 || M <= nc)
			return (dir + 2) % 4;
		return dir;
	}

	private int getScore(int sr, int sc) {
		int ref = board[sr][sc], score = 0;
		Deque<int[]> dq = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		dq.add(new int[]{sr, sc});
		visit[sr][sc] = true;
		while (!dq.isEmpty()) {
			int[] tmp = dq.poll();
			int r = tmp[0], c = tmp[1];
			score += board[r][c];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				if (nr < 0 || N <= nr || nc < 0 || M <= nc)
					continue;
				if (!visit[nr][nc] && board[nr][nc] == ref) {
					visit[nr][nc] = true;
					dq.add(new int[]{nr, nc});
				}
			}
		}
		return score;
	}

	public void solution() {
		int r = 0, c = 0, d = 0, totalScore = 0;
		for (int t = 0; t < K; t++) {
			r += dr[d];
			c += dc[d];
			rotateDice(d);

			totalScore += getScore(r, c);
			d = getNextDirection(r, c, d);
		}
		System.out.println(totalScore);
	}
}


class Main {
	public static void main(String[] args) throws IOException {
		Solution s = new Solution();
		s.solution();
	}
}