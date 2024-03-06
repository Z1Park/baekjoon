class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> keys = new ArrayDeque<>();
        boolean[] used = new boolean[rooms.size()];
        int cnt = 1;
        
        keys.add(0);
        used[0] = true;
        while (!keys.isEmpty()) {
            int key = keys.poll();
            List<Integer> newKeys = rooms.get(key);
            for (int newKey : newKeys) {
                if (used[newKey]) continue;
                keys.add(newKey);
                used[newKey] = true;
                cnt++;
            }
        }
        return cnt == rooms.size();
    }
}