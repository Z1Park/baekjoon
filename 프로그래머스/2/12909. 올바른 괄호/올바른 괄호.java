class Solution {
    boolean solution(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (open <= 0) return false;
            else open--;
        }
        if (open == 0) return true;
        return false;
    }
}