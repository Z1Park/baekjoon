import java.io.*;
import java.util.*;

public class Main {

	private static int N;
	private static long B;
	private static final long[][] A = new long[5][5], U = new long[5][5];
	private static final long[][] tmp = new long[5][5];

	private static void readValues() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		B = Long.parseLong(tmp[1]);

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				A[i][j] = Long.parseLong(tmp[j]);
			U[i][i] = 1;
		}
	}

	private static long[][] cross(long[][] M1, long[][] M2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = 0;
				for (int k = 0; k < N; k++)
					tmp[i][j] += M1[i][k] * M2[k][j];
				tmp[i][j] %= 1000;
			}
		}
		for (int i = 0; i < N; i++)
			M1[i] = Arrays.copyOf(tmp[i], N);
		return M1;
	}

	public static void main(String[] args) throws IOException {
		readValues();
		while (B > 0) {
			if (B % 2 == 1) cross(U, A);
			cross(A, A);
			B /= 2;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(U[i][j] + " ");
			System.out.println();
		}
	}
}