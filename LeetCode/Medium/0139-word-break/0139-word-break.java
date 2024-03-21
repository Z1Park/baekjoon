class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] possible = new boolean[s.length()+1];
        possible[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if (possible[i] && dict.contains(s.substring(i, j)))
                    possible[j] = true;
            }
        }
        return possible[s.length()];
    }
}