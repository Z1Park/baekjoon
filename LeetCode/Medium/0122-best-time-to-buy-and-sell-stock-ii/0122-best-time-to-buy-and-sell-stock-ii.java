class Solution {
    public int maxProfit(int[] prices) {
        Deque<Integer> stk = new ArrayDeque<>();
        int gain = 0;
        for (int price : prices) {
            while (!stk.isEmpty() && stk.peekLast() >= price)
                stk.pollLast();
            while (!stk.isEmpty() && stk.peekLast() < price)
                gain += price - stk.pollLast();
            stk.add(price);
        }
        return gain;
    }
}