class Solution {

    private int count;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph = new List[n+1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        count = 0;
        boolean[] visit = new boolean[n+1];
        for (int restric : restricted)
            visit[restric] = true;
        dfs(graph, visit, 0);
        return count;
    }

    public void dfs(List<Integer>[] graph, boolean[] visit, int node) {
        if (visit[node]) return;
        visit[node] = true;
        count++;

        for (int next : graph[node])
            dfs(graph, visit, next);
    }
}