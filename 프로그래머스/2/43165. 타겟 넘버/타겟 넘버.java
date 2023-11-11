class Solution {
    
    private int t;
    private int cnt = 0;
    
    private void dfs(int[] numbers, int idx, int sum) {
        if (idx >= numbers.length) {
            if (sum == t) cnt++;
            return;
        }
        dfs(numbers, idx+1, sum + numbers[idx]);
        dfs(numbers, idx+1, sum - numbers[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        this.t = target;
        dfs(numbers, 0, 0);
        return cnt;
    }
}