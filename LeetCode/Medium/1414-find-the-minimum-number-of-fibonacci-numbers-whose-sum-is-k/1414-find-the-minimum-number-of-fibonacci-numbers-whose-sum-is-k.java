class Solution {

    private List<Integer> fib = new ArrayList<>();

    public int findMinFibonacciNumbers(int k) {
        int prev = 1, curr = 1;
        while (curr <= k) {
            fib.add(0, curr);
            curr += prev;
            prev = curr - prev;
        }

        if (curr == k) return 1;
        return dfs(k, 0);
    }

    private int dfs(int k, int cnt) {
        for (int i = 0; i < fib.size(); i++) {
            int curr = fib.get(i);
            if (curr > k) continue;
            if (curr == k) return cnt+1;
            int result = dfs(k - curr, cnt+1);
            if (result != -1) return result;
        }
        return -1;
    }
}