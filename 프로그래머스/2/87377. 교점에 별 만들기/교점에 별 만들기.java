import java.util.*;
import javafx.util.Pair;
import static java.util.stream.Collectors.*;

class Solution {
    
    private boolean checkParallel(int[] line1, int[] line2) {
        long A = (long)line1[0], B = (long)line1[1], E = (long)line1[2];
        long C = (long)line2[0], D = (long)line2[1], F = (long)line2[2];
        if (A * D - B * C == 0) return true;
        return false;
    }
    
    private double[] getPoint(int[] line1, int[] line2) {
        long A = (long)line1[0], B = (long)line1[1], E = (long)line1[2];
        long C = (long)line2[0], D = (long)line2[1], F = (long)line2[2];
        long div = A * D - B * C;
        double x = (double)(B * F - E * D) / div;
        double y = (double)(E * C - A * F) / div;
        return new double[]{x, y};
    }
    
    public String[] solution(int[][] line) {
        Set<long[]> pointSet = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                if (checkParallel(line[i], line[j])) continue;
                double[] point = getPoint(line[i], line[j]);
                if (point[0] == (long)point[0] && point[1] == (long)point[1])
                    pointSet.add(new long[]{(long)point[0], (long)point[1]});
            }
        }
        List<long[]> pointList = pointSet.stream().collect(toList());
        pointList.forEach(e -> System.out.println(Arrays.toString(e)));
        long xMin = Long.MAX_VALUE, xMax = Long.MIN_VALUE;
        long yMin = Long.MAX_VALUE, yMax = Long.MIN_VALUE;
        for (long[] p : pointList) {
            long x = p[0], y = p[1];
            if (x < xMin) xMin = x;
            if (x > xMax) xMax = x;
            if (y < yMin) yMin = y;
            if (y > yMax) yMax = y;
        }
        final long N = yMax - yMin + 1, M = xMax - xMin + 1;
        Character[][] res = new Character[(int)N][(int)M];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++)
                res[i][j] = '.';
        }
        for (long[] p : pointList) {
            long x = p[0], y = p[1];
            res[(int)(N - 1L - y + yMin)][(int)(x - xMin)] = '*';
        }
        return Arrays.stream(res)
            .map(arr -> Arrays.stream(arr)
                 .map(String::valueOf).collect(joining()))
            .toArray(String[]::new);
    }
}
