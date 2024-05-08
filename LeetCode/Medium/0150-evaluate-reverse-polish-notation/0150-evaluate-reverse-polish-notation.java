class Solution {
    
    private int calculate(int num1, int num2, String oper) {
        return switch (oper.charAt(0)) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
    }
    
    public int evalRPN(String[] tokens) {
        // Deque<Integer> stk = new ArrayDeque<>();
        // for (String token : tokens) {
        //     if (Character.isDigit(token.charAt(token.length()-1)))
        //         stk.add(Integer.valueOf(token));
        //     else  {
        //         int num2 = stk.pollLast(), num1 = stk.pollLast();
        //         stk.add(calculate(num1, num2, token));
        //     }
        // }
        // return stk.poll();
        int[] stk = new int[6667];
        int idx = 0;
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length()-1)))
                stk[idx++] = Integer.valueOf(token);
            else {
                int num2 = stk[--idx];
                int num1 = stk[--idx];
                stk[idx++] = calculate(num1, num2, token);
            }
        }
        return stk[0];
    }
}