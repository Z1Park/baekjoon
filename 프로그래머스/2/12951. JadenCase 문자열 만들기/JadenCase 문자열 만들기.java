import java.util.Arrays;


class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        String[] newStrs = Arrays.stream(strs).map(str -> {
            if (str.length() <= 1)
                return str.toUpperCase();
            return str.substring(0, 1).toUpperCase() + 
                str.substring(1).toLowerCase();
        }).toArray(String[]::new);
        String res = String.join(" ", newStrs);
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        while (sb.length() != s.length())
            sb.append(' ');
        return sb.toString();
    }
}