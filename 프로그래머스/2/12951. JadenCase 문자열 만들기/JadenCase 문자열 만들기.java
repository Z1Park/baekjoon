import java.util.Arrays;
import static java.util.stream.Collectors.*;

class Solution {
    public String solution(String s) {
        String res = Arrays
            .stream(s.split(" "))
            .map(str -> {
                if (str.length() <= 1) return str.toUpperCase();
                return str.substring(0, 1).toUpperCase() + 
                    str.substring(1).toLowerCase();
            }).collect(joining(" "));
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        while (sb.length() != s.length())
            sb.append(' ');
        return sb.toString();
    }
}