class Solution {
    
    private int start = 0, len = 0;
    
    private void getPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int res = right - left - 1;
        if (len < res) {
            len = res;
            start = left+1;
        }
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            getPalindromeLength(s, i, i);
            getPalindromeLength(s, i, i+1);
        }
        return s.substring(start, start+len);
    }
}