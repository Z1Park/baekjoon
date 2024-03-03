class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            res.computeIfAbsent(String.valueOf(arr), k -> new ArrayList<>()).add(str);
        }
        return res.values().stream().toList();
    }
}