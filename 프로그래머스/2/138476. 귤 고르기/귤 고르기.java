import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine)
            map.put(t, map.getOrDefault(t, 0) + 1);
        List<Integer> list = map.values().stream().
            sorted((a, b) -> b - a).collect(toList());
        int cnt = 0, sum = 0;
        for (int e : list) {
            sum += e;
            cnt++;
            if (sum >= k) break;
        }
        return cnt;
    }
}