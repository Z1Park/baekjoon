class Solution {
    
    private void checkDP(int[] dp, Queue<Integer> que, int next, int curr) {
        if (dp[next] != -1 && dp[next] > dp[curr] + 1) {
            dp[next] = dp[curr] + 1;
            que.add(next);
        }
    }
    
    public int openLock(String[] deadends, String t) {
        int[] dp = new int[10001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (String deadend : deadends)
            dp[Integer.parseInt(deadend)] = -1;
        if (dp[0] == -1) return -1;
        dp[0] = 0;
        
        int target = Integer.parseInt(t);
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int i = 1; i < 10000; i *= 10) {
                int tmp = curr % (i * 10) / i;
                checkDP(dp, que, curr + i - (tmp == 9 ? i * 10 : 0), curr);
                checkDP(dp, que, curr - i + (tmp == 0 ? i * 10 : 0), curr);
            }
        }
        return dp[target] == Integer.MAX_VALUE ? -1 : dp[target];
    }
}