class Solution {
    
    private static final int MAX = 1000000;
    
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        for (int i = x+1; i <= y; i++) dp[i] = MAX;
        dp[x] = 0;
        int idx = x;
        while (dp[y] == MAX) {
            if (idx + n <= y)
                dp[idx+n] = Math.min(dp[idx+n], dp[idx] + 1);
            if (idx * 2 <= y)
                dp[idx*2] = Math.min(dp[idx*2], dp[idx] + 1);
            if (idx * 3 <= y)
                dp[idx*3] = Math.min(dp[idx*3], dp[idx] + 1);
            if (idx++ >= y) break;
        }
        if (dp[y] == MAX) return -1;
        return dp[y];
    }
}