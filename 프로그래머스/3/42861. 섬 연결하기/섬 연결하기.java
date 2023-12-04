import java.util.*;

class Solution {
    
    private List<List<Integer>> graph = new ArrayList<>();
    
    private boolean checkConnect(int n, int a, int b) {
        boolean[] visit = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(a);
        while (!dq.isEmpty()) {
            int node = dq.poll();
            if (node == b) return true;
            if (visit[node]) continue;
            visit[node] = true;
            List<Integer> nextNodes = graph.get(node);
            for (int next : nextNodes) {
                if (!visit[next]) dq.addLast(next);
            }
        }
        return false;
    }
    
    public int solution(int n, int[][] costs) {
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        Arrays.sort(costs, Comparator.comparing(arr -> arr[2]));
        int sum = 0, cnt = 0;
        for (int[] cost : costs) {
            if (!checkConnect(n, cost[0], cost[1])) {
                sum += cost[2];
                graph.get(cost[0]).add(cost[1]);
                graph.get(cost[1]).add(cost[0]);
                cnt++;
            }
            if (cnt >= n - 1) break;
        }
        return sum;
    }
}