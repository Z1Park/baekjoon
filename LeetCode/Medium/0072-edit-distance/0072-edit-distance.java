class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int i = 0; i <= word2.length(); i++)
            dp[0][i] = i;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
            }
        }
        System.out.println("     " + Arrays.toString(word2.toCharArray()));
        for (int i = 0; i <= word1.length(); i++) {
            String str = (i == 0 ? " " : word1.charAt(i-1)) + " " + Arrays.toString(dp[i]);
            System.out.println(str);
        }
        return dp[word1.length()][word2.length()];
    }
}