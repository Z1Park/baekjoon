import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<int[]> list = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		for (int l = 0; l < n; l++) {
			int curr = Integer.parseInt(br.readLine());
			list.add(new int[]{curr, l});
		}
		List<int[]> res = list.stream().sorted(Comparator.comparing((int[] a) -> a[0]))
						.collect(Collectors.toList());
		int max = IntStream.range(0, n).map(i -> res.get(i)[1] - i)
				.max().getAsInt() + 1;
		System.out.println(max);
	}
}