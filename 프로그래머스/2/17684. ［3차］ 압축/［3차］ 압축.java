import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = IntStream
            .rangeClosed('A', 'Z')
            .boxed()
            .collect(toMap(c -> Character.toString(c), 
                           c -> c - 'A' + 1));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < msg.length(); i++) {
            for (int j = msg.length(); j > i; j--) {
                String tmp = msg.substring(i, j);
                if (map.containsKey(tmp)) {
                    res.add(map.get(tmp));
                    if (j != msg.length())
                        map.put(msg.substring(i, j+1), map.size()+1);
                    i = j - 1;
                    break;
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}