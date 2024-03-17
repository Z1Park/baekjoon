import java.util.*;

class Solution {
    
    private int maxCount = 0;
    
    private void dfs(int[] info, int[][] edges, boolean[] visit, int node, int s, int w) {
        visit[node] = true;
        if (info[node] == 0) s++;
        else w++;
        if (s <= w) return;
        if (maxCount < s) maxCount = s;
        
        for (int i = 0; i < edges.length; i++) {
            if (visit[edges[i][0]] && !visit[edges[i][1]]) {
                boolean[] newVisit = visit.clone();
                dfs(info, edges, newVisit, edges[i][1], s, w);
            }
        }
    }
    
    public int solution(int[] info, int[][] edges) {
        dfs(info, edges, new boolean[info.length], 0, 0, 0);
        return maxCount;
    }
}