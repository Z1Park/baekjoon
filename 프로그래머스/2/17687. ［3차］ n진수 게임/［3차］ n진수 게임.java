import java.util.*;
import java.util.stream.*;

class Solution {
    
    private String decimalToBase(int n, int base) {
        StringBuilder sb = new StringBuilder();
        String outIdx = "ABCDEF";
        while (n > 0) {
            if (n % base >= 10) sb.append(outIdx.charAt(n % base - 10));
            else sb.append(n % base);
            n /= base;
        }
        return sb.reverse().toString();
    }
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        String curr = "0";
        int num = 1, round = 1, idx = 0;
        while (sb.length() < t) {
            if (round++ == p) sb.append(curr.charAt(idx));
            if (round > m) round = 1;
            if (++idx >= curr.length()) {
                curr = decimalToBase(num++, n);
                idx = 0;
            }
        }
        return sb.toString();
    }
}