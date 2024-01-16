import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[speeds.length];
        for (int i = 0; i < speeds.length; i++)
            days[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while (idx < days.length) {
            int cnt = 1, release = days[idx];
            while (idx+cnt < days.length && days[idx+cnt] <= release)
                cnt++;
            res.add(cnt);
            idx += cnt;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}