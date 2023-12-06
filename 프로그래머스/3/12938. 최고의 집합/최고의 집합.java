class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] res = new int[n];
        int mod = s / n;
        for (int i = 0; i < n; i++) res[i] = mod;
        s -= mod * n;
        int idx = n - 1;
        while (s-- > 0) res[idx--] += 1;
        return res;
    }
}