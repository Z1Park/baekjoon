import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        final int MAX = 30000;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] dik = new int[n+1];
        for (int i = 2; i <= n; i++) 
            dik[i] = MAX;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing(arr -> arr[1]));
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0], cnt = tmp[1];
            if (dik[node] < cnt) continue;
            List<Integer> nextNodes = graph.get(node);
            for (int nextNode : nextNodes) {
                if (dik[nextNode] <= cnt + 1) continue;
                dik[nextNode] = cnt + 1;
                pq.add(new int[]{nextNode, cnt+1});
            }
        }
        int cnt = 0, maxValue = 0;
        for (int d : dik) {
            if (maxValue < d) {
                maxValue = d;
                cnt = 1;
            }
            else if (maxValue == d) cnt++;
        }
        return cnt;
    }
}