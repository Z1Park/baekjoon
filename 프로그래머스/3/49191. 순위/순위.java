import java.util.*;

class Solution {
    
    private int calculateScore(List<List<Integer>> graph, int idx) {
        Set<Integer> set = new HashSet<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int e : graph.get(idx)) dq.add(e);
        while (!dq.isEmpty()) {
            int e = dq.poll();
            set.add(e);
            for (int tmp : graph.get(e)) {
                if (!set.contains(tmp))
                    dq.add(tmp);
            }
        }
        return set.size();
    }
    
    public int solution(int n, int[][] results) {
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            winGraph.add(new ArrayList<>());
            loseGraph.add(new ArrayList<>());
        }
        
        for (int[] result : results) {
            int win = result[0], lose = result[1];
            winGraph.get(win).add(lose);
            loseGraph.get(lose).add(win);
        }
        int[][] score = new int[n+1][2];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = calculateScore(winGraph, i);
            tmp += calculateScore(loseGraph, i);
            if (tmp == n - 1) cnt++;
        }
        return cnt;
    }
}