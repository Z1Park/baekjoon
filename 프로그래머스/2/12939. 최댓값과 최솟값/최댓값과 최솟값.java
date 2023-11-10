class Solution {
    public String solution(String s) {
        String[] strs = s.split(" ");
        int minVal = 1000000;
        int maxVal = -1000000;
        for (String tmp : strs) {
            int now = Integer.parseInt(tmp);
            if (now > maxVal) maxVal = now;
            if (now < minVal) minVal = now;
        }
        return Integer.toString(minVal) + " " + Integer.toString(maxVal);
    }
}