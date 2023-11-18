import java.util.*;

class Main {

	private static void checkBalance(String line) {
		Stack<Character> stk = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '(' || c == '[')
				stk.push(c);
			else if (c == ')') {
				if (stk.isEmpty() || stk.pop() != '(') {
					System.out.println("no");
					return;
				}
			}
			else if (c == ']') {
				if (stk.isEmpty() || stk.pop() != '[') {
					System.out.println("no");
					return;
				}
			}
		}
		if (!stk.isEmpty()) System.out.println("no");
		else System.out.println("yes");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String line = sc.nextLine();
			if (line.equals(".")) break;
			checkBalance(line);
		}
	}
}