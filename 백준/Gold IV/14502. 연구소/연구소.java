import java.util.*;
import java.io.*;

public class Main {

	private static int[] dr = {0, 1, 0, -1};
	private static int[] dc = {1, 0, -1, 0};
	private static List<int[]> blank = new ArrayList<>();
	private static List<int[]> virus = new ArrayList<>();
	private static List<List<int[]>> combination = new ArrayList<>();
	private static List<int[]> buffer = new ArrayList<>();

	private static void makeCombination(int start) {
		if (buffer.size() >= 3) {
			combination.add(List.copyOf(buffer));
			return;
		}
		for (int i = start; i < blank.size(); i++) {
			buffer.add(blank.get(i));
			makeCombination(i+1);
			buffer.remove(buffer.size()-1);
		}
	}

	private static int countClearArea(int N, int M, List<int[]> walls, int[][] origin) {
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++)
			board[i] = Arrays.copyOf(origin[i], M);
		for (int[] wall : walls)
			board[wall[0]][wall[1]] = 1;
		Deque<int[]> dq = new ArrayDeque<>(virus);
		while (!dq.isEmpty()) {
			int[] tmp = dq.poll();
			int r = tmp[0], c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i], nc = c + dc[i];
				if (nr < 0 || N <= nr || nc < 0 || M <= nc)
					continue;
				if (board[nr][nc] == 0) {
					board[nr][nc] = 2;
					dq.add(new int[]{nr, nc});
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int N = Integer.parseInt(nm[0]), M = Integer.parseInt(nm[1]);
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
				if (board[i][j] == 0) blank.add(new int[]{i, j});
				else if (board[i][j] == 2) virus.add(new int[]{i, j});
			}
		}
		makeCombination(0);
		int res = 0;
		for (List<int[]> c : combination) {
			int cnt = countClearArea(N, M, c, board);
			if (res < cnt) res = cnt;
		}
		System.out.println(res);
	}
}