import java.util.*;

class Solution {
    
    private double getX(double y, long r) {
        return Math.sqrt(r * r - y * y);
    }
    
    public long solution(int r1, int r2) {
        double y1 = 0.0, y2 = 0.0, x;
        long cnt = 0;
        for (double y = -r2; y <= r2; y += 1.0) {
            x = getX(y, r2);
            cnt += Math.floor(x) * 2 + 1;
        }
        for (double y = -r1; y <= r1; y += 1.0) {
            x = getX(y, r1);
            cnt -= Math.floor(x) * 2 + 1;
            if (x == (long) x) 
                cnt += (x == 0.0) ? 1 : 2;
        }
        return cnt;
    }
}