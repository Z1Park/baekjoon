import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private int[] divideAndConquer(int[][] arr, int r, int c, int n) {
        if (n == 1) return new int[]{1-arr[r][c], arr[r][c]};
        boolean flag = true;
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (arr[i][j] != arr[r][c]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        // boolean flag = IntStream.range(r, r+n)
        //     .allMatch(i -> IntStream.range(c, c+n)
        //         .map(j -> (int)arr[i][j]).distinct().count() == 1);
        if (flag) return new int[]{1-arr[r][c], arr[r][c]};
        else {
            int[] res = new int[2];
            int[] tmp1 = divideAndConquer(arr, r, c, n / 2);
            int[] tmp2 = divideAndConquer(arr, r+n/2, c, n / 2);
            int[] tmp3 = divideAndConquer(arr, r, c+n/2, n / 2);
            int[] tmp4 = divideAndConquer(arr, r+n/2, c+n/2, n / 2);
            res[0] += tmp1[0] + tmp2[0] + tmp3[0] + tmp4[0];
            res[1] += tmp1[1] + tmp2[1] + tmp3[1] + tmp4[1];
            return res;
        }
    }
    
    public int[] solution(int[][] arr) {
        return divideAndConquer(arr, 0, 0, arr.length);
    }
}