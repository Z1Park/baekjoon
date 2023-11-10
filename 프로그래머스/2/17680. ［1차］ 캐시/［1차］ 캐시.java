import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return 5 * cities.length;
        Map<String, Integer> map = new HashMap<>();
        int time = 0;
        for (String city : cities) {
            time++;
            String tmp = city.toLowerCase();
            if (!map.containsKey(tmp)) {
                time += 4;
                if (map.size() >= cacheSize) {
                    int minVal = Collections.min(map.values());
                    map.entrySet().removeIf(entry -> entry.getValue() == minVal);
                }
            }
            map.put(tmp, time);
        }
        return time;
    }
}