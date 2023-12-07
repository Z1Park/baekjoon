import java.util.*;

class Solution {
    
    private int getScore(int n, int idx, List<List<Integer>> graph) {
        int cnt = 0;
        boolean[] visit = new boolean[n+1];
        Deque<Integer> dq = new ArrayDeque<>();
        visit[idx] = true;
        dq.add(idx);
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            for (int next : graph.get(curr)) {
                if (visit[next]) continue;
                visit[next] = true;
                cnt++;
                dq.addLast(next);
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] results) {
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }
        for (int[] result : results) {
            winGraph.get(result[0]).add(result[1]);
            loseGraph.get(result[1]).add(result[0]);
        }
        int[][] score = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            score[i][0] = getScore(n, i, winGraph);
            score[i][1] = getScore(n, i, loseGraph);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (score[i][0] + score[i][1] == n - 1) 
                cnt++;
        }
        return cnt;
    }
}