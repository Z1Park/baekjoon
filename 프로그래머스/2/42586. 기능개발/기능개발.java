import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resList = new ArrayList<>();
        int days = 0;
        int i = 0;
        while (i < speeds.length) {
            int now = progresses[i] + days * speeds[i];
            if (now < 100)
                days += Math.ceil((double)(100 - now) / speeds[i]);
            int cnt = 0;
            while (i < speeds.length 
                   && progresses[i] + days * speeds[i] >= 100) {
                cnt++;
                i++;
            }
            resList.add(cnt);
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}