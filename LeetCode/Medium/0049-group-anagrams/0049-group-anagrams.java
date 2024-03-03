class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> res = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            res.computeIfAbsent(countMap, k -> new ArrayList<>())
                .add(str);
        }
        return res.values().stream().toList();
    }
}