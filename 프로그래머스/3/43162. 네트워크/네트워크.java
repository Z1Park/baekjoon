import java.util.*;
import java.util.stream.*;

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
        if (x < y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1)
                    union(i, j);
            }
        }
        for (int i = 0; i < n; i++)
            parent[i] = find(i);
        return Arrays.stream(parent).boxed().collect(Collectors.toSet()).size();
    }
}