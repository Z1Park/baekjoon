import java.util.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> list = Arrays
            .stream(s.substring(2, s.length() - 2).split("\\},\\{"))
            .map(str -> Arrays.stream(str.split(","))
                        .map(Integer::parseInt)
                        .collect(toList()))
            .sorted(Comparator.comparing(List::size))
            .collect(toList());
        Set<Integer> set = new LinkedHashSet<>();
        for (List<Integer> inner : list)
            set.addAll(inner);
        int[] res = set.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}