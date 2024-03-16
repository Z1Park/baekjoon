class Solution {
    public int trap(int[] height) {
        Deque<Integer> stk = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (!stk.isEmpty() && stk.peek() <= height[i]) {
                int h = stk.poll();
                while (!stk.isEmpty()) {
                    sum += h - stk.poll();
                }
            }
            stk.add(height[i]);
        }
        int h = stk.pollLast();
        int tmp = 0;
        while (!stk.isEmpty()) {
            if (h <= stk.peekLast()) {
                h = stk.pollLast();
                sum += tmp;
                tmp = 0;
            }
            else tmp += h - stk.pollLast();
        }
        return sum;
    }
}