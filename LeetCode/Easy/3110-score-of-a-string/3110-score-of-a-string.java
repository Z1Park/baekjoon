class Solution {
    public int scoreOfString(String s) {
        char[] chars = s.toCharArray();
        int score = 0;
        for (int i = 1; i < chars.length; i++)
            score += Math.abs(chars[i-1] - chars[i]);
        return score;
    }
}