import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine)
            map.put(t, map.getOrDefault(t, 0) + 1);
        List<Integer> list = map.values().stream()
            .sorted((a, b) -> b - a).collect(Collectors.toList());
        int cnt = 0, sum = 0;
        for (int e : list) {
            sum += e;
            cnt++;
            if (k <= sum) break;
        }
        return cnt;
    }
}