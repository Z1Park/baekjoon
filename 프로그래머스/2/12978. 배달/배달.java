import java.util.*;

class Solution {
    
    private static final long MAX = 500000L * 2000L * 50L + 1L;
    
    public int solution(int N, int[][] road, int K) {
        if (N == 1) return 1;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        for (int[] r : road) {
            graph.get(r[0]).add(new int[]{r[1], r[2]});
            graph.get(r[1]).add(new int[]{r[0], r[2]});
        }
        
        long[] dik = new long[N+1];
        boolean[] visit = new boolean[N+1];
        for (int i = 2; i <= N; i++)
            dik[i] = MAX;
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparing(arr ->  arr[1]));
        pq.add(new long[]{1L, dik[1]});
        while (!pq.isEmpty()) {
            int node = (int)pq.poll()[0];
            visit[node] = true;
            for (int[] next : graph.get(node)) {
                int nextNode = next[0], weight = next[1];
                if (dik[nextNode] > dik[node] + weight) {
                    dik[nextNode] = dik[node] + weight;
                    if (!visit[nextNode])
                        pq.add(new long[]{nextNode, dik[nextNode]});
                }
            }
        }
        
        int cnt = 0;
        for (int i = 1; i <= N; i++)
            if (dik[i] <= K) cnt++;
        return cnt;
    }
}