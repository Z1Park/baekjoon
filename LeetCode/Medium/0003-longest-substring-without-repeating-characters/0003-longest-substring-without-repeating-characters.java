class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] alp = new int[128];
        int maxLength = 0;
        for (int l = 0, r = 0; l < s.length(); l++) {
            if (l > r) r = l;
            while (r < s.length() && alp[s.charAt(r)] == 0)
                alp[s.charAt(r++)]++;
            maxLength = Integer.max(maxLength, r - l);
            alp[s.charAt(l)]--;
        }
        return maxLength;
    }
}