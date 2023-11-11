import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private boolean[] visit;
    private int minValue = 0;
    
    private void dfs(int[][] dungeons, int r, int depth) {
        if (depth > minValue) minValue = depth;
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && r >= dungeons[i][0]) {
                visit[i] = true;
                dfs(dungeons, r - dungeons[i][1], depth + 1);
                visit[i] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return minValue;
    }
}