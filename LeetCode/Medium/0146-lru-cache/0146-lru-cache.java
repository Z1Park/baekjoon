class LRUCache {
    
    private int capacity;
    private int time = 0, minTime = 0;
    private Map<Integer, List<Integer>> cache = new HashMap<>();
    private Map<Integer, Integer> que = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            List<Integer> cc = cache.get(key);
            if (minTime == cc.get(1))
                minTime++;
            que.remove(cc.get(1));
            cc.set(1, ++time);
            que.put(time, key);
            return cc.get(0);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        time++;
        if (cache.containsKey(key)) {
            List<Integer> cc = cache.get(key);
            if (minTime == cc.get(1))
                minTime++;
            que.remove(cc.get(1));
            cc.set(0, value);
            cc.set(1, time);
            que.put(time, key);
        }
        else {
            cache.put(key, Arrays.asList(value, time));
            que.put(time, key);
            if (cache.size() > capacity) {
                while (!que.containsKey(minTime))
                    minTime++;
                cache.remove(que.get(minTime));
                que.remove(minTime);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */