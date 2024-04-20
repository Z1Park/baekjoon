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
        que.add(new int[]{key, time});
        cache.put(key, value);
        timeMap.put(key, time);
        
        while (cache.size() > capacity) {
            int[] tmp = que.poll();
            if (timeMap.get(tmp[0]) == tmp[1])
                cache.remove(tmp[0]);
        }
        time++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */