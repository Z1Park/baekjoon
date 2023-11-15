import java.util.*;

class Solution {
    public int[] solution(int n) {
        if (n == 1) return new int[]{1};
        if (n == 2) return new int[]{1, 2, 3};
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j <= i; j++) arr[i][j] = -1;
        }
        int r = 0, c = 0, curr = 1;
        while (arr[r][c] == -1) {
            while (r < n && arr[r][c] == -1)
                arr[r++][c] = curr++;
            r -= 1;
            c += 1;
            while (c < arr[r].length && arr[r][c] == -1)
                arr[r][c++] = curr++;
            c -= 2;
            r -= 1;
            while (arr[r][c] == -1)
                arr[r--][c--] = curr++;
            r += 2;
            c += 1;
        }
        return Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
    }
}