class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] possible = new boolean[s.length()+1];
        possible[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!possible[i]) continue;
            for (String word : wordDict) {
                if (word.charAt(0) != s.charAt(i) || i+word.length() > s.length())
                    continue;
                if (word.equals(s.substring(i, i+word.length())))
                    possible[i+word.length()] = true;
            }
        }
        return possible[s.length()];
    }
}