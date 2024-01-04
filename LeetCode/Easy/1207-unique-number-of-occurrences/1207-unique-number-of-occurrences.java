import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : arr)
            map.put(e, map.getOrDefault(e, 0) + 1);
        Set<Integer> set = map.values().stream().collect(Collectors.toSet());
        return set.size() == map.values().size();
    }
}