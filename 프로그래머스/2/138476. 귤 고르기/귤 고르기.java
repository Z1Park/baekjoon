import java.util.*;
import static java.util.stream.Collectors.*;
import javafx.util.Pair;

class Solution {
    public int solution(int k, int[] tangerine) {
        Long[] arr = Arrays.stream(tangerine)
            .boxed()
            .collect(groupingBy(t-> t, mapping(t->t, counting())))
            .values()
            .stream()
            .sorted(Collections.reverseOrder())
            .toArray(Long[]::new);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= k) return i+1;
        }
        return tangerine.length;
    }
}