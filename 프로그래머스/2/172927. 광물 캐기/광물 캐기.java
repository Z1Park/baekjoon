import java.util.*;

class Solution {
    
    private int limit;
    private int minValue = 1250;
    
    private void dfs(int[] picks, String[] minerals, int p, int depth) {
        if (depth >= limit) {
            if (minValue > p)
                minValue = p;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;
            picks[i]--;
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if (depth * 5 + j >= minerals.length) break;
                int exp = i - "dis".indexOf(minerals[depth * 5 + j].charAt(0));
                if (exp < 0) exp = 0;
                tmp += Math.pow(5, exp);
            }
            dfs(picks, minerals, p + tmp, depth + 1);
            picks[i]++;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int picksCount = Arrays.stream(picks).sum();
        int mineralsCount = (int)Math.ceil((double)minerals.length / 5);
        limit = Math.min(picksCount, mineralsCount);
        dfs(picks, minerals, 0, 0);
        return minValue;
    }
}