class Solution {
    private boolean matchPattern(String word, String pattern) {
        Map<Character, Character> patternMap = new HashMap<>();
        Map<Character, Character> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ref = pattern.charAt(i);
            char c = word.charAt(i);
            if (patternMap.containsKey(ref)) {
                if (patternMap.get(ref) != c) return false;
            }
            else patternMap.put(ref, c);
            if (wordMap.containsKey(c)) {
                if (wordMap.get(c) !=  ref) return false;
            }
            else wordMap.put(c, ref);
        }
        return true;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (matchPattern(word, pattern))
                res.add(word);
        }
        return res;
    }
}