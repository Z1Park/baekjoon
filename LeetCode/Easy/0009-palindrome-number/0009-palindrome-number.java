class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int len = s.length() / 2;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
}