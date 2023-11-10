import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
            .collect(groupingBy(cloth -> cloth[1], 
                               mapping(elem -> elem, counting())))
            .values()
            .stream()
            .collect(reducing(1L, (a, b) -> a * (b + 1))).intValue() - 1;
    }
}