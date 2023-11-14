import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(int[] topping) {
        int cnt = 0;
        Map<Integer, Long> leftSide = new HashMap<>();
        Map<Integer, Long> rightSide = Arrays.stream(topping).boxed()
            .collect(groupingBy(e -> e, counting()));
        for (int cut = 0; cut < topping.length; cut++) {
            leftSide.put(topping[cut], leftSide.getOrDefault(topping[cut],0L)+1L);
            Long tmp = rightSide.get(topping[cut]);
            if (tmp == 1L) rightSide.remove(topping[cut]);
            else rightSide.put(topping[cut], tmp-1L);
            if (leftSide.size() == rightSide.size()) cnt++;
        }
        return cnt;
    }
}