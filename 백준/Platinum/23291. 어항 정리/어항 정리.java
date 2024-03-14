import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	int[] dr = {0, 1};
	int[] dc = {1, 0};


	private void dispenseFish(int[][] arr) {
		int R = arr.length, C = arr[0].length;
		int[][] move = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (arr[r][c] == 0)
					continue;
				for (int i = 0; i < 2; i++) {
					int nr = r + dr[i], nc = c + dc[i];
					if (nr < 0 || R <= nr || nc < 0 || C <= nc || arr[nr][nc] == 0)
						continue;
					int cnt = Math.abs(arr[r][c] - arr[nr][nc]) / 5;
					if (arr[r][c] > arr[nr][nc]) {
						move[r][c] -= cnt;
						move[nr][nc] += cnt;
					}
					else {
						move[r][c] += cnt;
						move[nr][nc] -= cnt;
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				arr[i][j] += move[i][j];
		}
	}

	private int[] rearrange(int[][] arr, int n) {
		int[] result = new int[n];
		int idx = 0;
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = arr.length-1; j >= 0; j--) {
				if (arr[j][i] != 0)
					result[idx++] = arr[j][i];
			}
		}
		return result;
	}

	private int[][] levitation1(int[] arr) {
		int[][] result = new int[20][arr.length];

		for (int i = 1; i < arr.length; i++)
			result[19][i] = arr[i];
		result[18][1] = arr[0];

		while (true) {
			int stackCount = 0, lastStack = 0;
			for (int i = 1; i < arr.length; i++) {
				if (result[18][i] != 0) {
					stackCount++;
					lastStack = i;
				}
			}
			int level = 0;
			for (int i = 19; result[i][lastStack] != 0; i--)
				level++;
			int startIndex = lastStack + 1;
			if (arr.length - startIndex < level) break;

			for (int i = 1; i <= stackCount; i++, lastStack--) {
				for (int j = 0; j < level; j++) {
					result[19-i][startIndex+j] = result[19-j][lastStack];
					result[19-j][lastStack] = 0;
				}
			}
		}
		return result;
	}

	private int[][] levitation2(int[] arr) {
		int quarter = arr.length / 4;
		int[][] result = new int[4][quarter];

		int idx = 0;
		for (int i = quarter-1; i >= 0; i--)
			result[2][i] = arr[idx++];
		for (int i = 0; i < quarter; i++)
			result[1][i] = arr[idx++];
		for (int i = quarter-1; i >= 0; i--)
			result[0][i] = arr[idx++];
		for (int i = 0; i < quarter; i++)
			result[3][i] = arr[idx++];
		return result;
	}

	private void addOneFish(int[] arr) {
		Set<Integer> minSet = new HashSet<>();
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (minValue > arr[i]) {
				minSet.clear();
				minSet.add(i);
				minValue = arr[i];
			}
			else if (minValue == arr[i])
				minSet.add(i);
		}
		for (int e : minSet)
			arr[e]++;
	}

	private int getMaxMinDifference(int[] arr) {
		int maxCount = Integer.MIN_VALUE, minCount = Integer.MAX_VALUE;
		for (int num : arr) {
			if (maxCount < num) maxCount = num;
			if (minCount > num) minCount = num;
		}
		return maxCount - minCount;
	}

	public int solution(int[] arr, int N, int K) {
		int cnt = 0;
		while (true) {
			if (K >= getMaxMinDifference(arr))
				return cnt;

			cnt++;
			addOneFish(arr);
			int[][] rot1 = levitation1(arr);
			dispenseFish(rot1);
			arr = rearrange(rot1, N);

			int[][] rot2 = levitation2(arr);
			dispenseFish(rot2);
			arr = rearrange(rot2, N);
		}
	}
}


class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] vars = br.readLine().split(" ");
		int N = Integer.parseInt(vars[0]), K = Integer.parseInt(vars[1]);
		int[] arr = new int[N];
		String[] nums = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(nums[i]);

		Solution s = new Solution();
		int result = s.solution(arr, N, K);
		System.out.println(result);
	}
}