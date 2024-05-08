class Solution {
    
    private int calculate(int num1, int num2, String oper) {
        return switch (oper.charAt(0)) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> -1;
        };
    }
    
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);
        
        Deque<Integer> stk = new ArrayDeque<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length()-1)))
                stk.add(Integer.valueOf(token));
            else  {
                int num2 = stk.pollLast(), num1 = stk.pollLast();
                stk.add(calculate(num1, num2, token));
            }
        }
        return stk.poll();
    }
}