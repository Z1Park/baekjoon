class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dpMap = new HashMap<>();
        int result = 0;
        for (String word : words) {
            int maxCount = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i+1);
                maxCount = Math.max(maxCount, dpMap.getOrDefault(prev, 0) + 1);
            }
            dpMap.put(word, maxCount);
            if (result < maxCount)
                result = maxCount;
        }
        return result;
    }
}