import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int coverage = 2 * w + 1;
        int last = 0, cnt = 0;
        for (int s : stations) {
            double area = s - w - 1 - last;
            cnt += (int)Math.ceil(area / coverage);
            last = s + w;
        }
        cnt += (int)Math.ceil((double) (n - last) / coverage);
        return cnt;
    }
}