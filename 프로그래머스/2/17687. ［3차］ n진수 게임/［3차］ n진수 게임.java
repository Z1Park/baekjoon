import java.util.*;
import java.util.stream.*;

class Solution {
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.length() < t * m)
            sb.append(Integer.toString(num++, n));
        String ref = sb.toString();
        sb.delete(0, sb.length());
        for (int i = 0; i < t; i++)
            sb.append(ref.charAt(p - 1 + m * i));
        return sb.toString().toUpperCase();
    }
}