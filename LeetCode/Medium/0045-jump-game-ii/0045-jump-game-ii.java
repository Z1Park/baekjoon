class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int i = tmp[0], count = tmp[1];
            if (i == nums.length-1) break;
            for (int j = 1; j <= nums[i]; j++) {
                int idx = i + j;
                if (idx >= nums.length) break;
                if (count + 1 < dp[idx]) {
                    dp[idx] = Math.min(dp[idx], count + 1);
                    pq.add(new int[]{idx, count+1});
                }
            }
        }
        return dp[nums.length-1];
    }
}