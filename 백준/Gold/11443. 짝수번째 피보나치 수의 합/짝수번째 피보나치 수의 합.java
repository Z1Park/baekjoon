import java.io.*;
import java.util.Arrays;

public class Main {

	private static final long MOD = 1000000007;
	private static final long[][] F = {{1, 1}, {1, 0}};

	private static long[][] cross(long[][] M1, long[][] M2) {
		long[][] res = new long[2][2];
		res[0][0] = (M1[0][0] * M2[0][0] % MOD + M1[0][1] * M2[1][0] % MOD) % MOD;
		res[0][1] = (M1[0][0] * M2[0][1] % MOD + M1[0][1] * M2[1][1] % MOD) % MOD;
		res[1][0] = (M1[1][0] * M2[0][0] % MOD + M1[1][1] * M2[1][0] % MOD) % MOD;
		res[1][1] = (M1[1][0] * M2[0][1] % MOD + M1[1][1] * M2[1][1] % MOD) % MOD;
		return res;
	}

	private static long[][] power(long[][] M, long n) {
		if (n == 0 || n == 1) return M;
		M = power(M, n / 2);
		M = cross(M, M);
		if (n % 2 == 1) M = cross(M, F);
		return M;
	}

	private static long fib(long n) {
		long[][] res = power(F, n);
		return res[0][0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		if (n == 0) System.out.println(0);
		else if (n % 2 == 0) System.out.println(fib(n)-1);
		else System.out.println(fib(n-1)-1);
	}
}