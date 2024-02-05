import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]), d = Integer.parseInt(line[1]), k = Integer.parseInt(line[2]);
		String c = line[3];
		List<String> foods = new ArrayList<>();
		for (int i = 0; i < N; i++)
			foods.add(br.readLine());
		Map<String, Integer> foodMap = new HashMap<>();
		for (int i = 1; i <= k; i++) {
			String food = foods.get(foods.size() - i);
			foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
		}
		int idx = N - k, maxValue = 0;
		for (int i = 0; i < N; i++) {
			String removeFood = foods.get(idx);
			foodMap.put(removeFood, foodMap.get(removeFood) - 1);
			foodMap.remove(removeFood, 0);
			String addFood = foods.get(i);
			foodMap.put(addFood, foodMap.getOrDefault(addFood, 0) + 1);
			int count = foodMap.size();
			if (!foodMap.containsKey(c)) count++;
			if (count > maxValue) maxValue = count;
			if (++idx >= N) idx -= N;
		}
		System.out.println(maxValue);
	}
}