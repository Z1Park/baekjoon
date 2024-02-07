import java.util.*;
import java.io.*;

public class Main {

	private static class Solution {
		private final int[] dr = {0, 1, 0, -1};
		private final int[] dc = {1, 0, -1, 0};
		private int N, M;
		private int[][] maze;

		private void readParameteres() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] nm = br.readLine().split(" ");
			M = Integer.parseInt(nm[0]);
			N = Integer.parseInt(nm[1]);
			maze = new int[N][M];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++)
					maze[i][j] = line.charAt(j) - '0';
			}
		}

		private int bfs() {
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
			pq.add(new int[]{0, 0, 0});
			maze[0][0] = -1;
			while (!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int r = tmp[0], c = tmp[1], w = tmp[2];
				if (r == N-1 && c == M-1) {
					return w;
				}
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i], nc = c + dc[i];
					if (nr < 0 || N <= nr || nc < 0 || M <= nc)
						continue;
					if (maze[nr][nc] != -1) {
						pq.add(new int[]{nr, nc, w + maze[nr][nc]});
						maze[nr][nc] = -1;
					}
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) throws IOException {
		Solution sol = new Solution();
		sol.readParameteres();
		System.out.println(sol.bfs());
	}
}