import java.util.*;

class Solution {
    
    private int[] parent;
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return;
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        Arrays.sort(costs, Comparator.comparing(arr -> arr[2]));
        int sum = 0;
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                sum += cost[2];
            }
        }
        return sum;
    }
}