import java.io.*;
import java.util.*;

public class Main {

	private static Deque<Character> stk = new ArrayDeque<>();
	private static Deque<Integer> values = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pathes = br.readLine();

		for (int i = 0; i < pathes.length(); i++) {
			char c = pathes.charAt(i);
			if (c == '(' || c == '[') {
				stk.add(c);
				values.add(0);
			}
			else {
				if (stk.isEmpty()) {
					values.clear();
					values.add(0);
					break;
				}
				char p = stk.pollLast();
				if ((p == '(' && c == ')') || (p == '[' && c == ']')) {
					int value = 0;
					while (stk.size() + 1 < values.size()) {
						value += values.pollLast();
					}
					if (value == 0) value = (c == ')') ? 2 : 3;
					else value *= (c == ')') ? 2 : 3;
					values.add(values.pollLast() + value);
				}
				else {
					values.clear();
					values.add(0);
					break;
				}
			}
		}

		System.out.println(values.getFirst());
	}
}