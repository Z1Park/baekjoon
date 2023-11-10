import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        long range = right - left + 1;
        int[] res = new int[(int)range];
        for (int i = 0; i < range; i++) {
            int row = (int)((left + i) / n);
            int col = (int)((left + i) % n);
            res[i] = Math.max(row, col) + 1;
        }
        return res;
    }
}