import java.util.*;
import javafx.util.Pair;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (m.containsKey(tangerine[i]))
                m.put(tangerine[i], m.get(tangerine[i]) + 1);
            else
                m.put(tangerine[i], 1);
        }
        List<Integer> keySet = new ArrayList<>(m.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return m.get(o2).compareTo(m.get(o1));
            }
        });
        int sum = 0;
        int cnt = 0;
        for (Integer key : keySet) {
            sum += m.get(key);
            cnt++;
            if (sum >= k) return cnt;
        }
        return tangerine.length;
    }
}