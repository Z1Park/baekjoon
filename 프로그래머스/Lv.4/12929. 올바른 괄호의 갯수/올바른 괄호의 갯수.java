class Solution {
    
    private int N, cnt = 0;
    
    private void dfs(int openCount, int closeCount) {
        if (openCount == N && closeCount == N) {
            cnt++;
            return;
        }
        if (openCount < N)
            dfs(openCount+1, closeCount);
        if (closeCount < N && openCount > closeCount)
            dfs(openCount, closeCount+1);
    }
    
    public int solution(int n) {
        N = n;
        dfs(0, 0);
        return cnt;
    }
}