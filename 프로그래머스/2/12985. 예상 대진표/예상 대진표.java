import java.util.*;

class Solution {
    public int solution(int n, int a, int b) {
        a -= 1;
        b -= 1;
        int cnt = 1;
        while (a / 2 != b / 2) {
            cnt++;
            n /= 2;
            a /= 2;
            b /= 2;
        }
        return cnt;
    }
}