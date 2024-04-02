class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            Character find = map1.get(c1);
            if (find == null) map1.put(c1, c2);
            else if (find != c2) return false;
            find = map2.get(c2);
            if (find == null) map2.put(c2, c1);
            else if (find != c1) return false;
        }
        return true;
    }
}