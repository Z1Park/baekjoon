class MinStack {
    
    private TreeMap<Integer, Integer> orderedMap = new TreeMap<>();
    private Deque<Integer> stk = new ArrayDeque<>();

    public MinStack() {
    }
    
    public void push(int val) {
        stk.add(val);
        orderedMap.put(val, orderedMap.getOrDefault(val, 0) + 1);
    }
    
    public void pop() {
        int res = stk.pollLast();
        while (!orderedMap.containsKey(res))
            res = stk.pollLast();
        int count = orderedMap.get(res);
        if (count == 1) orderedMap.remove(res);
        else orderedMap.put(res, count - 1);
    }
    
    public int top() {
        while (!orderedMap.containsKey(stk.peekLast()))
            stk.pollLast();
        return stk.peekLast();
    }
    
    public int getMin() {
        return orderedMap.firstEntry().getKey();
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