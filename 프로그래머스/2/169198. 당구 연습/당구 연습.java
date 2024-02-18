import java.util.*;

class Solution {
    
    private final int[] cushion = new int[4];
    
    private int square(double value) {
        return (int)(value * value);
    }
    
    private boolean isBetween(int s, int b, int t) {
        if (s <= b && b <= t) return true;
        if (t <= b && b <= s) return true;
        return false;
    }
    
    private int getDistance(int sx, int sy, int tx, int ty) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int x = tx + (i % 2 == 0 ? 0 : (cushion[i] - tx) * 2);
            int y = ty + (i % 2 == 1 ? 0 : (cushion[i] - ty) * 2);
            if (i % 2 == 0 && sx == tx && isBetween(sy, ty, y)) continue;
            if (i % 2 == 1 && sy == ty && isBetween(sx, tx, x)) continue;
            int distance = square(sx - x) + square(sy - y);
            if (distance < minValue)
                minValue = distance;
        }
        System.out.println();
        return minValue;
    }
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        cushion[2] = n; // x
        cushion[3] = m; // y
        List<Integer> res = new ArrayList<>();
        for (int[] ball : balls)
            res.add(getDistance(startX, startY, ball[0], ball[1]));
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}