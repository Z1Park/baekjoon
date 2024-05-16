class Solution {
    public boolean isValid(String s) {
        char[] stk = new char[s.length()];
        int idx = -1;
        String open = "({[", close = ")}]";
        for (char c : s.toCharArray()) {
            int i = open.indexOf(c);
            if (i != -1) stk[++idx] = c;
            else if (idx < 0 || open.indexOf(stk[idx]) != close.indexOf(c)) return false;
            else idx--;
        }
        return idx == -1;
    }
}