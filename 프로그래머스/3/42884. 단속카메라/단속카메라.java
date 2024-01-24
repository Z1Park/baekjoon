import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparing((int[] arr) -> arr[1]));
        int cnt = 0, last = -30001;
        for (int[] route : routes) {
            if (last < route[0]) {
                last = route[1];
                cnt++;
            }
        }
        return cnt;
    }
}