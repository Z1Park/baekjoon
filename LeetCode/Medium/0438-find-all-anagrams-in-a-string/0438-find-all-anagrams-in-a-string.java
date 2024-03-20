class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        
        char[] ref = new char[26];
        for (int i = 0; i < p.length(); i++)
            ref[p.charAt(i) - 'a']++;
        
        List<Integer> result = new ArrayList<>();
        char[] window = new char[26];
        int l = 0, r = 0;
        for (; r < p.length(); r++)
            window[s.charAt(r) - 'a']++;
        for (; r < s.length(); l++, r++) {
            if (Arrays.equals(ref, window))
                result.add(l);
            window[s.charAt(r) - 'a']++;
            window[s.charAt(l) - 'a']--;
        }
        if (Arrays.equals(ref, window))
            result.add(s.length() - p.length());
        return result;
    }
}