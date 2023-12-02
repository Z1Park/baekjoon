import java.util.*;

class Solution {
    
    private String t;
    private boolean[] check;
    private int minValue = 60;
    
    private void dfs(String[] words, int depth, String curr) {
        if (curr.equals(t)) {
            if (minValue > depth) minValue = depth;
            return;
        }
        if (depth >= words.length) return;
        for (int i = 0; i < words.length; i++) {
            if (check[i]) continue;
            int cnt = 0;
            for (int j = 0; j < curr.length(); j++) {
                if (curr.charAt(j) != words[i].charAt(j)) cnt++;
            }
            if (cnt == 1) {
                check[i] = true;
                dfs(words, depth + 1, words[i]);
                check[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        t = target;
        check = new boolean[words.length];
        dfs(words, 0, begin);
        return (minValue == 60) ? 0 : minValue;
    }
}