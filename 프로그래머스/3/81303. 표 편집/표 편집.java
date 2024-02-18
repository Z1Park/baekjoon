import java.util.*;

class Solution {
    
    private char[] states;
    private int[] prev, next;
    private Deque<Integer> stk = new ArrayDeque<>();
    
    public String solution(int n, int k, String[] commands) {
        states = new char[n];
        prev = new int[n];
        next = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            states[i] = 'O';
        }
        
        for (String cmd : commands) {
            if (cmd.charAt(0) == 'U') {
                int count = Integer.parseInt(cmd.substring(2, cmd.length()));
                while (count-- > 0)
                    k = prev[k];
            }
            else if (cmd.charAt(0) == 'D') {
                int count = Integer.parseInt(cmd.substring(2, cmd.length()));
                while (count-- > 0)
                    k = next[k];
            }
            else if (cmd.charAt(0) == 'C') {
                if (next[k] < n) prev[next[k]] = prev[k];
                if (prev[k] >= 0) next[prev[k]] = next[k];
                
                states[k] = 'X';
                stk.add(k);
                k = (next[k] >= n) ? prev[k] : next[k];
            }
            else {
                int idx = stk.pollLast();
                states[idx] = 'O';
                
                if (next[idx] < n) prev[next[idx]] = idx;
                if (prev[idx] >= 0) next[prev[idx]] = idx;
            }
        }
        return String.valueOf(states);
    }
}