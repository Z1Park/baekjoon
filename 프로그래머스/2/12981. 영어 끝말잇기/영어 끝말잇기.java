import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int i = 1, round = 1;
        char c = words[0].charAt(0);
        for (String word : words) {
            if (c != word.charAt(0) || set.contains(word))
                return new int[]{i, round};
            c = word.charAt(word.length() - 1);
            set.add(word);
            if (++i > n) {
                i = 1;
                round++;
            }
        }
        return new int[]{0, 0};
    }
}