import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparing(arr -> arr[1]));
        int cnt = 0, lastCam = -30001;
        for (int[] e : routes) {
            if (lastCam < e[0]) {
                cnt++;
                lastCam = e[1];
            }
        }
        return cnt;
    }
}