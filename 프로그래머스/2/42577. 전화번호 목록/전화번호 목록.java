import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        Set<String> s = new HashSet<>();
        for (String phoneNumber : phoneBook) s.add(phoneNumber);
        return Arrays.stream(phoneBook)
            .filter(str -> IntStream
                 .range(1, str.length())
                 .mapToObj(i -> str.substring(0, i))
                 .anyMatch(s::contains))
            .collect(toList()).size() == 0;
    }
}