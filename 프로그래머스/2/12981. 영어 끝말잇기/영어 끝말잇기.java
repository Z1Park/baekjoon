import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> s = new HashSet<>();
        s.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)
                || s.contains(words[i]))
                return new int[]{i % n + 1, i / n + 1};
            s.add(words[i]);
        }
        return new int[]{0, 0};
    }
}