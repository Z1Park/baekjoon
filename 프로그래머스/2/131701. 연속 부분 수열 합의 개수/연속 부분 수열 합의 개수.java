import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                int idx = 0;
                while (idx < i) {
                    sum += elements[(j + idx) % elements.length];
                    idx++;
                }
                s.add(sum);
            }
        }
        return s.size();
    }
}