class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<int[]> stk = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stk.isEmpty() && stk.peekLast()[1] < temperatures[i]) {
                int idx = stk.pollLast()[0];
                result[idx] = i - idx;
            }
            stk.add(new int[]{i, temperatures[i]});
        }
        return result;
    }
}