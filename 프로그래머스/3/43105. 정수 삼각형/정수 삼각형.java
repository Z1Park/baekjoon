class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            int last = triangle[i].length - 1;
            for (int j = 1; j < last; j++)
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            dp[i][last] = dp[i-1][last-1] + triangle[i][last];
        }
        int max = 0, last = dp.length - 1;
        for (int i = 0; i < dp[last].length; i++) {
            if (max < dp[last][i])
                max = dp[last][i];
        }
        return max;
    }
}