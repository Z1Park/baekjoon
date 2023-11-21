import java.util.*;
import java.io.*;

class Main {

	private static final int MAX = 2000000;
	private static boolean[] isPrime = new boolean[MAX];

	private static void 에라토스테네스의채() {
		for (int i = 2; i < MAX; i++) isPrime[i] = true;
		for (int i = 2; i < MAX; i++) {
			if (!isPrime[i]) continue;
			for (int j = i * 2; j < MAX; j += i)
				isPrime[j] = false;
		}
	}

	private static boolean checkPalindrome(int n) {
		String tmp = Integer.toString(n);
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp.charAt(i) != tmp.charAt(tmp.length() - 1 - i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		에라토스테네스의채();
		int n = Integer.parseInt(br.readLine());
		for (int i = n; i < MAX; i++) {
			if (!isPrime[i]) continue;
			if (checkPalindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}
}