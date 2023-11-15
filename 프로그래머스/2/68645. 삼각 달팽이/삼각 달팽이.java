import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j <= i; j++) arr[i][j] = -1;
        }
        int r = -1, c = 0, curr = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) ++r;
                else if (i % 3 == 1) ++c;
                else {--r; --c;}
                arr[r][c] = curr++;
            }
        }
        return Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
    }
}