class RandomizedSet {
    
    private Set<Integer> set = new HashSet<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) return false;
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        int rnd = (int)(Math.random() * (set.size()));
        List<Integer> list = new ArrayList<>(set);
        int value = list.get(rnd);
        return value;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */