class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        
        char[] ref = new char[26];
        for (int i = 0; i < p.length(); i++)
            ref[p.charAt(i) - 'a']++;
        
        List<Integer> result = new ArrayList<>();
        char[] window = new char[26];
        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;
            if (i >= p.length()) window[s.charAt(i-p.length()) - 'a']--;
            if (Arrays.equals(ref, window))
                result.add(i - p.length() + 1);
        }
        return result;
    }
}