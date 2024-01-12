class Solution {
    
    private int minValue = 51;
    private boolean[] used;
    
    private int getDiffCount(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) cnt++;
        }
        return cnt;
    }
    
    private void dfs(String[] words, String word, String target, int depth) {
        if (word.equals(target)) {
            if (minValue > depth) minValue = depth;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (used[i]) continue;
            int cnt = getDiffCount(word, words[i]);
            if (cnt != 1) continue;
            used[i] = true;
            dfs(words, words[i], target, depth+1);
            used[i] = false;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        used = new boolean[words.length];
        dfs(words, begin, target, 0);
        return (minValue == 51) ? 0 : minValue;
    }
}