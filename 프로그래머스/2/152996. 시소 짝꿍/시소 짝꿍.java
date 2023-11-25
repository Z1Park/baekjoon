import java.util.*;

class Solution {
    public long solution(int[] weights) {
        int maxWeight = 0;
        for (int weight : weights) {
            if (maxWeight < weight) maxWeight = weight;
        }
        int[] realWeights = new int[maxWeight + 1];
        int[] relationWeights = new int[4 * maxWeight + 1];
        for (int i = 0; i < relationWeights.length; i++) {
            if (i < realWeights.length) realWeights[i] = -1;
            relationWeights[i] = -1;
        }
        long res = 0;
        for (int weight : weights) {
            realWeights[weight]++;
            res += realWeights[weight];
            for (int i = 2; i <= 4; i++) {
                relationWeights[weight * i]++;
                res += relationWeights[weight * i] - realWeights[weight];
            }
        }
        return res;
    }
}