import java.util.*;
import java.util.stream.*;

class Solution {
    
    private boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    
    public int solution(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 26; i++)
            map.put((char)('a' + i), new ArrayList<>());
        for (int i = 0; i < s.length(); i++)
            map.get(s.charAt(i)).add(i);
        map.values().forEach(list -> Collections.sort(
            list, Collections.reverseOrder()));
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.get(s.charAt(i));
            for (int j = 0; j < list.size(); j++) {
                int idx = list.get(j);
                if (idx < i || res >= idx - i + 1) break;
                if (checkPalindrome(s, i, idx)) {
                    res = idx - i + 1;
                    break;
                }
            }
        }
        return res;
    }
}