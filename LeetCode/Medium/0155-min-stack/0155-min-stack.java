class MinStack {
    
    private Deque<Integer> stk = new ArrayDeque<>();
    private int min = Integer.MAX_VALUE;

    public MinStack() {
    }
    
    public void push(int val) {
        stk.add(val);
        if (min > val) min = val;
    }
    
    public void pop() {
        int res = stk.pollLast();
        if (min == res) {
            int nextMin = Integer.MAX_VALUE;
            for (int e : stk) {
                if (nextMin > e) nextMin = e;
            }
            min = nextMin;
        }
    }
    
    public int top() {
        return stk.peekLast();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */