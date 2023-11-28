import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt((int[] t) -> t[1]));
        int answer = 0, last = -1;
        for (int[] target : targets) {
            if (target[0] > last) {
                answer++;
                last = target[1] - 1;
            }
        }
        return answer;
    }
}