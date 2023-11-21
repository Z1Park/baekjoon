import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int[][] tmp = Arrays.stream(data)
            .sorted(Comparator.comparing((int[] e) -> e[col - 1])
                    .thenComparing((int[] e) -> -e[0]))
            .toArray(int[][]::new);
        int res = IntStream.rangeClosed(row_begin-1, row_end-1)
            .map(i -> Arrays.stream(tmp[i]).map(e -> e % (i+1)).sum())
            .reduce((a, b) -> a ^ b).orElse(0);
        return res;
    }
}