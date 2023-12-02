import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] weightArr = new int[n+1];
        for (int i = 2; i <= n; i++) weightArr[i] = 100000;
        int maxValue = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        while (!dq.isEmpty()) {
            int node = dq.poll();
            List<Integer> currEdge = graph.get(node);
            int weight = weightArr[node] + 1;
            for (int e : currEdge) {
                if (weightArr[e] > weight) {
                    weightArr[e] = weight;
                    dq.addLast(e);
                    if (maxValue < weightArr[e]) maxValue = weightArr[e];
                }
            }
        }
        int cnt = 0;
        for (int w : weightArr) {
            if (w == maxValue) cnt++;
        }
        return cnt;
    }
}