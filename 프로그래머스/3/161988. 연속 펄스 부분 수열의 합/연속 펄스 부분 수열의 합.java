import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long[] prefixSum = new long[sequence.length + 1];
        int sign = 1;
        for (int i = 0; i < sequence.length; i++) {
            prefixSum[i+1] = prefixSum[i] + sequence[i] * sign;
            sign *= -1;
        }
        long minValue = Long.MAX_VALUE, maxValue = Long.MIN_VALUE;
        for (int i = 0; i <= sequence.length; i++) {
            if (minValue > prefixSum[i]) minValue = prefixSum[i];
            if (maxValue < prefixSum[i]) maxValue = prefixSum[i];
        }
        return maxValue - minValue;
    }
}