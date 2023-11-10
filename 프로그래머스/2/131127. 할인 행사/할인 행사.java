import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i]))
                map.put(discount[i], map.get(discount[i]) + 1);
            else map.put(discount[i], 1);
        }
        int cnt = 1;
        for (int i = 0; i < want.length; i++) {
            if (!map.containsKey(want[i]) || number[i] != map.get(want[i])) {
                cnt--;
                break;
            }
        }
        for (int i = 10; i < discount.length; i++, cnt++) {
            map.put(discount[i-10], map.get(discount[i-10]) - 1);
            if (map.containsKey(discount[i]))
                map.put(discount[i], map.get(discount[i]) + 1);
            else map.put(discount[i], 1);
            for (int j = 0; j < want.length; j++) {
                if (!map.containsKey(want[j]) || number[j] != map.get(want[j])) {
                    cnt--;
                    break;
                }
            }
        }
        return cnt;
    }
}