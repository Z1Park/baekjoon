import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    
    private Map<String, Long> stringToMap(String str) {
        return IntStream.range(0, str.length() - 1)
            .mapToObj(i -> str.substring(i, i+2))
            .filter(s -> s.chars().allMatch(Character::isLetter))
            .map(String::toLowerCase)
            .collect(groupingBy(e->e, counting()));
    }
    
    public int solution(String str1, String str2) {
        Map<String, Long> map1 = stringToMap(str1);
        Map<String, Long> map2 = stringToMap(str2);
        Set<String> unionSet = new HashSet<>(map1.keySet());
        unionSet.addAll(map2.keySet());
        Set<String> interSet = new HashSet<>(map1.keySet());
        interSet.retainAll(map2.keySet());
        int inter = 0;
        for (String str : interSet)
            inter += Math.min(map1.get(str), map2.get(str));
        int union = 0;
        for (String str : unionSet)
            union += Math.max(map1.getOrDefault(str, 0L), 
                              map2.getOrDefault(str, 0L));
        if (union == 0) return 65536;
        double res = (double)inter / union;
        return (int)(res * 65536);
    }
}