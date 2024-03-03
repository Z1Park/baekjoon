class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] alps = new char[26];
            for (int i = 0; i < str.length(); i++)
                alps[str.charAt(i)-'a']++;
            res.computeIfAbsent(String.valueOf(alps), k -> new ArrayList<>())
                .add(str);
        }
        return new ArrayList<>(res.values());
    }
}