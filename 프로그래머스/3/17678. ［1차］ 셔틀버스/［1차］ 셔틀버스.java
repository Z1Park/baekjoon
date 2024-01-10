import java.util.*;

class Solution {
    
    private String getTime(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60, min = time % 60;
        if (hour < 10) sb.append("0");
        sb.append(Integer.toString(hour));
        sb.append(":");
        if (min < 10) sb.append("0");
        sb.append(Integer.toString(min));
        return sb.toString();
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        int[] table = Arrays.stream(timetable)
            .mapToInt(time -> {
                String[] arr = time.split(":");
                return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
            }).sorted().toArray();
        int time = 9 * 60, idx = 0;
        for (int i = 0; i < n; i++, time += t) {
            if (i == n-1) m--;
            int cnt = 0;
            while (cnt < m && table[idx] <= time) {
                idx++;
                cnt++;
            }
        }
        time -= t;
        if (idx < table.length)
            time = Math.min(table[idx] - 1, time);
        return getTime(time);
    }
}