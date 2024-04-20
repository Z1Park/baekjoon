class LRUCache {
    
    private int capacity;
    private int time = 0;
    private Map<Integer, Integer> cache = new HashMap<>();
    private Map<Integer, Integer> timeMap = new HashMap<>();
    private Queue<int[]> que = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            que.add(new int[]{key, time});
            timeMap.put(key, time);
            time++;
            return cache.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (!cache.containsKey(key) && capacity == cache.size()) {
            while (que.peek()[1] != timeMap.get(que.peek()[0]))
                que.poll();
            int[] tmp = que.poll();
            cache.remove(tmp[0]);
            timeMap.remove(tmp[0]);
        }
        que.add(new int[]{key, time});
        cache.put(key, value);
        timeMap.put(key, time);
        time++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */