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
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0')
                return res;
        }
        return "0";
    }
}