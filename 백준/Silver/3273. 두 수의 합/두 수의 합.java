import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1;
		int cnt = 0;
		while (left < right) {
			int tmp = arr[left] + arr[right];
			if (tmp == x) {
				cnt++;
				left++;
			}
			else if (tmp < x) left++;
			else right--;
		}
		System.out.println(cnt);
	}
}