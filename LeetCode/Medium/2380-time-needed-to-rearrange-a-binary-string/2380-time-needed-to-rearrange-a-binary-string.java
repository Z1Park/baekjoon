class Solution {
    public int secondsToRemoveOccurrences(String s) {
        boolean[] ones = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++)
            ones[i] = (s.charAt(i) == '1');
        
        int limit = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (j < limit && !ones[j] && ones[j+1]) {
                    ones[j] = true;
                    ones[j+1] = false;
                    flag = false;
                    j++;
                }
            }
            if (flag) return i;
        }
        return s.length();
    }
}