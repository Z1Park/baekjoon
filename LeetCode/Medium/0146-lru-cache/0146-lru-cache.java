class LRUCache {
    
    private int capacity;
    private int time = 0;
    private Map<Integer, List<Integer>> cache = new HashMap<>();
    private PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            List<Integer> cc = cache.get(key);
            cc.set(1, time++);
            return cc.get(0);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        time++;
        if (cache.containsKey(key)) {
            List<Integer> cc = cache.get(key);
            cc.set(0, value);
            cc.set(1, time);
        }
        else {
            cache.put(key, Arrays.asList(value, time));
            que.add(new int[]{time, key});
            if (cache.size() > capacity) {
                while (que.size() > capacity) {
                    int[] tmp = que.poll();
                    List<Integer> cc = cache.get(tmp[1]);
                    if (cc.get(1) > tmp[0]) {
                        tmp[0] = cc.get(1);
                        que.add(tmp);
                    }
                    else cache.remove(tmp[1]);
                }
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