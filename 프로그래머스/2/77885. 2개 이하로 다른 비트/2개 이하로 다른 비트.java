import java.util.*;

class Solution {
    
    private long f(long x) {
        long bit = 1;
        while ((x & bit) == bit) bit <<= 1;
        x |= bit;
        return x & ~(bit >> 1);
    }
    
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers).map(this::f).toArray();
    }
}