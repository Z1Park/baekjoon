class Solution {

    private boolean[] used;
    private int minValue = Integer.MAX_VALUE;

    private int getDiffCount(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                cnt++;
        }
        return cnt;
    }

    private void dfs(int depth, String currGen, String target, String[] bank) {
        if (depth >= minValue) return;
        if (currGen.equals(target)) {
            if (minValue > depth) minValue = depth;
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            if (used[i] || getDiffCount(currGen, bank[i]) > 1) continue;
            used[i] = true;
            dfs(depth+1, bank[i], target, bank);
            used[i] = false;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        used = new boolean[bank.length];
        dfs(0, startGene, endGene, bank);
        return (minValue == Integer.MAX_VALUE) ? -1 : minValue;
    }
}