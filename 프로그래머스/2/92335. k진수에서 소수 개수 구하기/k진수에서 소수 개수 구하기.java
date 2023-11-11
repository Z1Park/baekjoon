import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private String decimalToBase(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
    
    private boolean isPrime(long n) {
        if (n <= 1) return false;
        long max = (long)(Math.sqrt(n));
        for (long i = 2; i <= max; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        String[] trans = decimalToBase(n, k).split("0");
        return Arrays.stream(trans)
            .filter(s -> s.length() >= 1)
            .map(Long::parseLong)
            .filter(this::isPrime)
            .collect(counting()).intValue();
    }
}