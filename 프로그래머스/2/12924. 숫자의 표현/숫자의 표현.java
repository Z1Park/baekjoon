class Solution {
    public int solution(int n) {
        int[] prefix = new int[n+1];
        for (int i = 1; i < prefix.length; i++)
            prefix[i] = prefix[i-1] + i;
        int left = 0;
        int right = 0;
        int cnt = 0;
        while (right <= n) {
            int tmp = prefix[right] - prefix[left];
            if (tmp == n) {
                cnt++;
                right++;
            }
            else if (tmp > n) left++;
            else right++;
        }
        return cnt;
    }
}