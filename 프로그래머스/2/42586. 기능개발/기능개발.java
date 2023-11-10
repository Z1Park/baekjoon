import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> res = new ArrayList<>();
        int days = 0;
        for (int i = 0; i < speeds.length;) {
            days = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) days++;
            int cnt = 0;
            while (i < speeds.length 
                   && progresses[i] + speeds[i] * days >= 100) {
                i++;
                cnt++;
            }
            res.add(cnt);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}