class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] chars = s.toCharArray();
        int count = 0, limit = chars.length - 1;
        
        while (true) {
            boolean swapped = false;
            for (int i = 0; i < limit; i++) {
                if (chars[i] == '0' && chars[i+1] == '1') {
                    swapped = true;
                    chars[i++] = '1';
                    chars[i] = '0';
                }
            }
            if (!swapped) break;
            count++;
        }
        return count;
    }
}