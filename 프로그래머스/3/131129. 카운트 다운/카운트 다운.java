import java.util.*;

class Solution {
    
    private List<Integer> singleOrBool = new ArrayList<>();
    private List<Integer> doubleOrTriple = new ArrayList<>();
    private static final int inf = Integer.MAX_VALUE;
    
    
    public int[] solution(int target) {
        singleOrBool.add(50);
        for (int i = 1; i <= 20; i++) {
            singleOrBool.add(i);
            doubleOrTriple.add(i * 2);
            doubleOrTriple.add(i * 3);
        }
        
        int[][] dp = new int[target+1][2];
        for (int i = 1; i <= target; i++)
            dp[i][0] = inf;
        dp[0][0] = 0;
        for (int sb : singleOrBool) {
            for (int i = sb; i <= target; i++) {
                if (dp[i-sb][0] == inf) continue;
                int nextTry = dp[i-sb][0] + 1;
                int nextCount = dp[i-sb][1] + 1;
                if (dp[i][0] > nextTry) {
                    dp[i][0] = nextTry;
                    dp[i][1] = nextCount;
                }
                else if (dp[i][0] == nextTry && dp[i][1] < nextCount)
                    dp[i][1] = nextCount;
            }
        }
        for (int dt : doubleOrTriple) {
            for (int i = dt; i <= target; i++) {
                if (dp[i-dt][0] == inf) continue;
                int nextTry = dp[i-dt][0] + 1;
                if (dp[i][0] > nextTry) {
                    dp[i][0] = nextTry;
                    dp[i][1] = dp[i-dt][1];
                }
                else if (dp[i][0] == nextTry && dp[i][1] < dp[i-dt][1])
                    dp[i][1] = dp[i-dt][1];
            }
        }
        return dp[target];
    }
}