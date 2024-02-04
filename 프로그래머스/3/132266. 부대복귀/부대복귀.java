import java.util.*;

class Solution {
    
    private final int MAX = 500001;
    private int[] dist;
    private List<List<Integer>> graph = new ArrayList<>();
    
    private void makeGraph(int n, int[][] roads) {
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
    }
    
    private void getDistance(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing(arr -> arr[1]));
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0], weight = tmp[1];
            if (dist[node] < weight) continue;
            List<Integer> nextNodes = graph.get(node);
            for (int nextNode : nextNodes) {
                if (dist[nextNode] > weight + 1) {
                    dist[nextNode] = weight + 1;
                    pq.add(new int[]{nextNode, weight + 1});
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        dist = new int[n+1];
        Arrays.fill(dist, MAX);
        makeGraph(n, roads);
        
        getDistance(destination);
        List<Integer> res = new ArrayList<>();
        for (int source : sources) {
            if (dist[source] == MAX) res.add(-1);
            else res.add(dist[source]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}