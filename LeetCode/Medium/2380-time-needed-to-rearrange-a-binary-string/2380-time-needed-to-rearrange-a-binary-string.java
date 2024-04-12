class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int lim = s.length() - 1, count = 0;
        boolean flag = true;
        while (flag) {
            count++;
            StringBuilder sb = new StringBuilder();
            flag = false;
            for (int i = 0; i < s.length(); i++) {
                if (i < lim && s.charAt(i) == '0' && s.charAt(i+1) == '1') {
                    flag = true;
                    sb.append("10");
                    i++;
                }
                else sb.append(s.charAt(i));
            }
            s = sb.toString();
        }
        return count-1;
    }
}