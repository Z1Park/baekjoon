class Solution {
    
    private List<List<int[]>> graph = new ArrayList<>();
    
    
    public int minReorder(int n, int[][] connections) {
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1});
            graph.get(conn[1]).add(new int[]{conn[0], 0});
        }
        
        int res = 0;
        boolean[] visit = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        visit[0] = true;
        dq.add(0);
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            List<int[]> nextNodes = graph.get(curr);
            for (int[] next : nextNodes) {
                int nextNode = next[0], nextWeight = next[1];
                if (!visit[nextNode]) {
                    res += nextWeight;
                    visit[nextNode] = true;
                    dq.add(nextNode);
                }
            }
        }
        return res;
    }
}