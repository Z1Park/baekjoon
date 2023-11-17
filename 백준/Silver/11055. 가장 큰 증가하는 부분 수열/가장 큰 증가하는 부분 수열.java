import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
		List<Integer> dp = new ArrayList<>();
		dp.add(arr[0]);
		for (int i = 1; i < n; i++) {
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && tmp < dp.get(j)) tmp = dp.get(j);
			}
			dp.add(tmp + arr[i]);
		}
		System.out.println(Collections.max(dp));
	}
}