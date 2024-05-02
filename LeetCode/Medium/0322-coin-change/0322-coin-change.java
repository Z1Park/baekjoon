class Solution {
    public int coinChange(int[] coins, int amount) {
        final int MAX = 10_001;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
        }
        return (dp[amount] == MAX ? -1 : dp[amount]);
    }
}