class Solution {
    public String makeGood(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char vv = Character.isUpperCase(c) ? 
                Character.toLowerCase(c) : Character.toUpperCase(c);
            if (!stk.isEmpty() && stk.peekLast() == vv)
                stk.pollLast();
            else stk.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty())
            sb.append(stk.poll());
        return sb.toString();
    }
}