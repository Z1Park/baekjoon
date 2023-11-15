import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(n % 3 + 1);
            n /= 3;
        }
        return sb.reverse().toString().replace('3', '4');
    }
}