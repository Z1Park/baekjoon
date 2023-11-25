import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> transList = new ArrayList<>();
        while (k != 1) {
            transList.add(k);
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
        }
        transList.add(k);
        int len = transList.size() - 1;
        double totalArea = 0;
        double[] area = new double[len];
        for (int i = 0; i < len; i++) {
            int a = transList.get(i), b = transList.get(i+1);
            area[i] = Math.min(a, b) + (double)Math.abs(a - b) / 2;
            totalArea += area[i];
        }
        double[] answer = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int end = -1 * ranges[i][1];
            if (ranges[i][0] + end > len) {
                answer[i] = -1;
                continue;
            }
            double tmp = 0;
            for (int j = 0; j < ranges[i][0]; j++)
                tmp += area[j];
            for (int j = 0; j < end; j++)
                tmp += area[len - 1 - j];
            answer[i] = totalArea - tmp;
        }
        return answer;
    }
}