class Solution {    
    
    private static final int MAX = 1000000;
    
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        for (int i = x; i <= y; i++) dp[i] = MAX;
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (i+n <= y) dp[i+n] = Math.min(dp[i+n], dp[i] + 1);
            if (i*2 <= y) dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
            if (i*3 <= y) dp[i*3] = Math.min(dp[i*3], dp[i] + 1);
            if (dp[y] != MAX) break;
        }
        return (dp[y] == MAX) ? -1 : dp[y];
    }
}