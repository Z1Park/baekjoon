import java.util.*;

class Solution {
    
    private List<Long> numList = new LinkedList<>();
    private List<Character> operList = new LinkedList<>();
    private Set<Character> used = new LinkedHashSet<>();
    private long maxValue = Long.MIN_VALUE;
    
    private long operate(char oper, long n1, long n2) {
        switch (oper) {
            case '*':
                return n1 * n2;
            case '+':
                return n1 + n2;
            default:
                return n1 - n2;
        }
    }
    
    private long calculate() {
        List<Long> nums = new LinkedList<>(numList);
		List<Character> opers = new LinkedList<>(operList);
		for (char u : used) {
			for (int i = 0; i < opers.size(); i++) {
				char oper = opers.get(i);
				if (opers.get(i) != u) continue;
				long num = operate(oper, nums.get(i), nums.get(i+1));
				nums.set(i, num);
				nums.remove(i+1);
				opers.remove(i--);
			}
		}
        return nums.get(0);
    }
    
    private void dfs(int depth) {
        if (depth >= 3) {
            long curr = Math.abs(calculate());
            if (curr > maxValue) maxValue = curr;
            return;
        }
        for (int i = 0; i < 3; i++) {
            char oper = "+*-".charAt(i);
            if (used.contains(oper)) continue;
            used.add(oper);
            dfs(depth+1);
            used.remove(oper);
        }
    }
    
    public long solution(String expression) {
        int idx = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!Character.isDigit(c)) {
                numList.add(Long.parseLong(expression.substring(idx, i)));
                operList.add(c);
                idx = i + 1;
            }
        }
        numList.add(Long.parseLong(expression.substring(idx, expression.length())));
        
        dfs(0);
        return maxValue;
    }
}