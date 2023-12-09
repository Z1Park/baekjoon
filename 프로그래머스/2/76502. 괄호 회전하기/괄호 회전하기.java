import java.util.*;

class Solution {
    
    private String open = "[({";
    private String closed = "])}";
    
    public int solution(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt++;
            Deque<Character> stk = new ArrayDeque<>();
            for (int idx = 0; idx < s.length(); idx++) {
                char c = s.charAt((idx + i) % s.length());
                if (open.indexOf(c) != -1)
                    stk.addLast(c);
                else {
                    if (stk.isEmpty() || closed.indexOf(c) != open.indexOf(stk.pollLast())) {
                        cnt--;
                        stk.clear();
                        break;
                    }
                }
            }
            if (!stk.isEmpty()) cnt--;
        }
        return cnt;
    }
}