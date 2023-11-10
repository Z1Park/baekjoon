import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1]))
                map.put(cloth[1], map.get(cloth[1]) + 1);
            else
                map.put(cloth[1], 2);
        }
        int res = 1;
        Collection<Integer> list = map.values();
        for (Integer elem : list)
            res *= elem;
        return res - 1;
    }
}