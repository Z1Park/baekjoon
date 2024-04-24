class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] alp = new char[26];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                alp[c-'a']++;
            }
            map.computeIfAbsent(Arrays.toString(alp), k -> new ArrayList<>())
                .add(str);
        }
        return map.values().stream().toList();
    }
}