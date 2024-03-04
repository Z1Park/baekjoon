class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, maxScore = 0;
        Arrays.sort(tokens);
        int l = 0, r = tokens.length-1;
        while (l <= r) {
            boolean flag = true;
            if (power >= tokens[l]) {
                power -= tokens[l++];
                score++;
                flag = false;
            }
            else if (score >= 1) {
                power += tokens[r--];
                score--;
                flag = false;
            }
            
            if (score > maxScore)
                maxScore = score;
            if (flag) break;
        }
        return maxScore;
    }
}