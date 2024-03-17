import java.util.*;

class Solution {
    
    private int maxScore = 0;
    private int[] result;
    
    
    private boolean isLower(int[] arrow) {
        for (int i = arrow.length-1; i >= 0; i--) {
            if (result[i] < arrow[i]) return true;
            if (result[i] > arrow[i]) return false;
        }
        return false;
    }
    
    private void dfs(int[] info, int[] arrow, int idx, int n, int aScore, int rScore) {
        if (n == 0 || idx >= info.length) {
            if (aScore >= rScore) return;
            int score = rScore - aScore;
            if (maxScore < score) {
                maxScore = score;
                result = arrow.clone();
            }
            else if (maxScore == score && isLower(arrow)) {
                result = arrow.clone();
            }
            return;
        }
        
        for (int i = idx; i < info.length; i++) {
            if (i == info.length - 1) {
                arrow[i] = n;
                dfs(info, arrow, i+1, n-arrow[i], aScore, rScore);
                arrow[i] = 0;
                continue;
            }
            if (info[i] < n) {
                int curr = 10 - i;
                arrow[i] = info[i]+1;
                if (info[i] == 0)
                    dfs(info, arrow, i+1, n-arrow[i], aScore, rScore+curr);
                else dfs(info, arrow, i+1, n-arrow[i], aScore-curr, rScore+curr);
                arrow[i] = 0;
            }
        }
    }
    
    public int[] solution(int n, int[] info) {
        int appechScore = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != 0) appechScore += 10 - i;
        }
        
        dfs(info, new int[11], 0, n, appechScore, 0);
        if (result == null) return new int[]{-1};
        else return result;
    }
}