import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	private final long[][] f = {{1, 1}, {1, 0}};
	private final static int MOD = 1000000007;


	private long[][] cross(long[][] m1, long[][] m2) {
		long[][] result = new long[2][2];
		result[0][0] = (m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0]) % MOD;
		result[0][1] = (m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]) % MOD;
		result[1][0] = (m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0]) % MOD;
		result[1][1] = (m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]) % MOD;
		return result;
	}

	private long[][] power(long[][] matrix, long n) {
		if (n == 1) return matrix;
		long[][] result = power(matrix, n/2);
		result = cross(result, result);
		if (n % 2 == 1) result = cross(result, matrix);
		return result;
	}

	public int solution(long n) {
		if (n == 0) return 0;
		long[][] result = power(f, n);
		return (int) result[0][1];
	}
}


class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());

		Solution s = new Solution();
		int result = s.solution(n);
		System.out.println(result);
	}
}