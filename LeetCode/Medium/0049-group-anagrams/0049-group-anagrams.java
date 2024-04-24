class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] alp = new char[26];
            for (int i = 0; i < str.length(); i++)
                alp[str.charAt(i) - 'a']++;
            String key = String.valueOf(alp);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}