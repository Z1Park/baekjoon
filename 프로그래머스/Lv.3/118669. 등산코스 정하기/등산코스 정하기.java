import java.util.*;

class Solution {
    
    private List<List<int[]>> graph = new ArrayList<>();
    private Set<Integer> summitSet = new HashSet<>();
    private final int MAX = 10000001;
    private int[] res = {-1, MAX};
    
    private void makeGraph(int n, int[][] paths) {
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] path : paths) {
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }
    }
    
    private void bfs(int n, int gate, int[] gates) {
        int[] dik = new int[n+1];
        for (int i = 0; i <= n; i++)
            dik[i] = MAX;
        for (int g : gates)
            dik[g] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing(arr -> arr[1]));
        pq.add(new int[]{gate, 0});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0], cost = tmp[1];
            if (res[1] < cost || dik[node] < cost) continue;
            if (summitSet.contains(node)) continue;
            List<int[]> nextNodes = graph.get(node);
            for (int[] nextNode : nextNodes) {
                int nextCost = Math.max(nextNode[1], cost);
                if (dik[nextNode[0]] <= nextCost) continue;
                pq.add(new int[]{nextNode[0], nextCost});
                dik[nextNode[0]] = nextCost;
            }
        }
        for (int summit : summitSet) {
            if (res[1] > dik[summit] || (res[1] == dik[summit] && res[0] > summit)) {
                res[0] = summit;
                res[1] = dik[summit];
            }
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        makeGraph(n, paths);
        for (int summit : summits)
            summitSet.add(summit);
        for (int gate : gates)
            bfs(n, gate, gates);
        return res;
    }
}