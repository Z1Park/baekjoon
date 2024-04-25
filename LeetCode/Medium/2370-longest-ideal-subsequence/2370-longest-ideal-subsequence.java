class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        
        int maxValue = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i] = 1;
            char c = s.charAt(i);
            for (int j = 0; j <= k; j++) {
                char down = (char)(c - j);
                if (down >= 'a' && map.containsKey(down)) {
                    int idx = map.get(down);
                    dp[i] = Math.max(dp[i], dp[idx] + 1);
                }
                char up = (char)(c + j);
                if (up <= 'z' && map.containsKey(up)) {
                    int idx = map.get(up);
                    dp[i] = Math.max(dp[i], dp[idx] + 1);
                }
            }
            if (!map.containsKey(c)) map.put(c, i);
            else if (dp[map.get(c)] < dp[i]) map.put(c, i);
            
            if (maxValue < dp[i]) maxValue = dp[i];
        }
        return maxValue;
    }
}