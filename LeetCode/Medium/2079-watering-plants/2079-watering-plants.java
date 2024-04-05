class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int step = 0, water = capacity, len = plants.length-1;
        for (int i = 0; i < len; i++) {
            step++;
            water -= plants[i];
            if (water < plants[i+1]) {
                step += (i + 1) * 2;
                water = capacity;
            }
        }
        return step+1;
    }
}