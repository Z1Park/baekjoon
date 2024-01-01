import java.util.*;
import java.util.stream.*;

class Solution {
    
    private Deque<int[]> res = new ArrayDeque<>();
    
    private void move(int n, int a, int b) {
        if (n == 1) {
            res.add(new int[]{a, b});
            return;
        }
        int tmp = 6 - a - b;
        move(n-1, a, tmp);
        res.add(new int[]{a, b});
        move(n-1, tmp, b);
    }
    
    public int[][] solution(int n) {
        move(n, 1, 3);
        return res.stream().toArray(int[][]::new);
    }
}