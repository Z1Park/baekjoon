import java.util.*;

class Solution {
    
    private int[] parent;
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
    
    private boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return false;
        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
    
    private int count() {
        int x = find(1), cnt1 = 1, cnt2 = 0;
        for (int i = 2; i < parent.length; i++) {
            if (x == find(i)) cnt1++;
            else cnt2++;
        }
        return Math.abs(cnt1 - cnt2);
    }
    
    public int solution(int n, int[][] wires) {
        int diff = n;
        for (int i = 0; i < wires.length; i++) {
            parent = new int[n+1];
            for (int j = 1; j <= n; j++)
                parent[j] = j;
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                union(wires[j][0], wires[j][1]);
            }
            int res = count();
            if (res < diff) diff = res;
        }
        return diff;
    }
}