import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes)
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        return map.values().stream()
            .map(a -> a + 1).reduce((a, b) -> a * b).orElse(0) - 1;
    }
}