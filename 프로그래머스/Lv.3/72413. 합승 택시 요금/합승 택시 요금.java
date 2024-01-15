import java.util.*;

class Solution {
    
    private final int MAX = 100000 * 200;
    private List<List<int[]>> graph = new ArrayList<>();
    private int[][] dik;
    private int cost;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dik = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j <= n; j++)
                dik[i][j] = MAX;
        }
        for (int[] fare : fares) {
            graph.get(fare[0]).add(new int[]{fare[1], fare[2]});
            graph.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }
        
        for (int start = 1 ; start <= n; start++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0]-y[0]);
            dik[start][start] = 0;
            pq.add(new int[]{0, start});
            while (!pq.isEmpty()) {
                int[] tmp = pq.poll();
                int cost = tmp[0], node = tmp[1];
                if (cost > dik[start][node]) continue;
                List<int[]> nextNodes = graph.get(node);
                for (int[] next : nextNodes) {
                    int nextCost = cost + next[1];
                    if (nextCost < dik[start][next[0]]) {
                        dik[start][next[0]] = nextCost;
                        pq.add(new int[]{nextCost, next[0]});
                    }
                }
            }
        }
        cost = dik[s][a] +  dik[s][b];
        for (int i = 1; i <= n; i++) {
            int tmp = dik[s][i] + dik[i][a] + dik[i][b];
            if (cost > tmp) cost = tmp;
        }
        return cost;
    }
}