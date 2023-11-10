import java.util.*;

class Solution {
    
    private boolean checkMatch(Character a, Character b) {
        if (a == '[' && b == ']') return true;
        else if (a == '(' && b == ')') return true;
        else if (a == '{' && b == '}') return true;
        return false;
    }
    
    public int solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt++;
            Stack<Character> stk = new Stack<>();
            for (int idx = 0; idx < s.length(); idx++) {
                int now = (i+idx) % s.length();
                if (s.charAt(now) == '(' || s.charAt(now) == '{' || s.charAt(now) == '[') {
                    stk.push(s.charAt(now));
                }
                else {
                    if (stk.empty() || !checkMatch(stk.peek(), s.charAt(now))) {
                        cnt--;
                        stk.clear();
                        break;
                    }
                    stk.pop();
                }
            }
            if (!stk.empty()) cnt--;
        }
        return cnt;
    }
}