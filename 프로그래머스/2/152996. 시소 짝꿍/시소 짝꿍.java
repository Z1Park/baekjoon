import java.util.*;

class Solution {
    public long solution(int[] weights) {
        int[] realWeight = new int[1001];
        int[] distWeight = new int[4001];
        long cnt = 0;
        for (int weight : weights) {
            int tmp = 0;
            for (int i = 2; i <= 4; i++) {
                int curr = weight * i;
                tmp += distWeight[curr];
                distWeight[curr] += 1;
                tmp -= realWeight[weight];
            }
            tmp += realWeight[weight];
            realWeight[weight] += 1;
            cnt += tmp;
        }
        return cnt;
    }
}