class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] check = new boolean[len+1];
        for (int i = 0; i < len; i++) {
            if (i > 0 && !check[i]) continue;
            for (int j = i+1; j <= len; j++) {
                String tmp = s.substring(i, j);
                if (set.contains(tmp)) check[j] = true;
            }
        }
        return check[len];
    }
}