import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        for (int[] score : scores) {
            if (scores[0][0] < score[0] && scores[0][1] < score[1])
                return -1;
        }
        int rank = 1, sum = scores[0][0] + scores[0][1];
        for (int[] score : scores) {
            if (score[0] + score[1] > sum) {
                boolean flag = true;
                for (int j = 0; j < scores.length; j++) {
                    if (scores[j][0] > score[0] && scores[j][1] > score[1]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) rank++;
            }
        }
        return rank;
    }
}