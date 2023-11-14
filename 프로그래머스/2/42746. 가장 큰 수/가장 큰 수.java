import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        String res = String.join("", Arrays.stream(numbers)
            .mapToObj(Integer::toString)
            .sorted(new Comparator<String>(){
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o2 + o1)-Integer.parseInt(o1 + o2);
                }
            }).toArray(String[]::new));
        if (res.charAt(0) == '0') return "0";
        return res;
    }
}