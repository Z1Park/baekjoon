import java.util.*;

class Solution {
    
    private long calculate(char o, long n1, long n2) {
        if (o == '*') return n1 * n2;
        if (o == '+') return n1 + n2;
        return n1 - n2;
    }
    
    private long getResult(List<Long> nums, List<Character> opers, char[] priority) {
        for (char p : priority) {
            List<Integer> position = new ArrayList<>();
            int idx = 0;
            for (char o : opers) {
                if (o == p) position.add(idx);
                idx++;
            }
            int cnt = 0;
            for (int i = 0; i < position.size(); i++) {
                idx = position.get(i) - cnt++;
                opers.remove(idx);
                long n1 = nums.remove(idx);
                long n2 = nums.remove(idx);
                nums.add(idx, calculate(p, n1, n2));
            }
        }
        return nums.get(0);
    }
    
    public long solution(String expression) {
        List<Long> nums = new LinkedList<>();
        List<Character> opers = new LinkedList<>();
        int idx = 0;
        while (idx < expression.length()) {
            if (!Character.isDigit(expression.charAt(idx))) {
                opers.add(expression.charAt(idx++));
                continue;
            }
            int tmp = idx + 1;
            while (tmp < expression.length() 
                   && Character.isDigit(expression.charAt(tmp)))
                tmp++;
            nums.add(Long.parseLong(expression.substring(idx, tmp)));
            idx = tmp;
        }
        String pri = "*+-";
        long maxValue = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                for (int k = 0; k < 3; k++) {
                    if (i == k || j == k) continue;
                    char[] tmpPri = new char[]{
                        pri.charAt(i), pri.charAt(j), pri.charAt(k)};
                    List<Long> tmpNums = new LinkedList<>(nums);
                    List<Character> tmpOpers = new LinkedList<>(opers);
                    long result = Math.abs(getResult(tmpNums, tmpOpers, tmpPri));
                    if (maxValue < result) maxValue = result;
                }
            }
        }
        return maxValue;
    }
}