class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zeros = 0, continuous = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result = Math.max(result, zeros + continuous);
                if (zeros > 0) continuous++;
            }
            else  {
                zeros++;
                if (continuous > 0) continuous--;
            }
        }
        return result;
    }
}