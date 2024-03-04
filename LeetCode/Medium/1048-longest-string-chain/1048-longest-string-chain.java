class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dpMap = new HashMap<>();
        int result = 0;
        for (String word : words) {
            int maxCount = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                String prev = sb.deleteCharAt(i).toString();
                if (dpMap.containsKey(prev))
                    maxCount = Math.max(maxCount, dpMap.getOrDefault(prev, 0) + 1);
            }
            dpMap.put(word, maxCount);
            if (result < maxCount)
                result = maxCount;
        }
        return result;
    }
}