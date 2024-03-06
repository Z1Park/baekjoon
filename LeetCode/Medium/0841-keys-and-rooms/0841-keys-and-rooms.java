class Solution {
    
    private int cnt = 0;
    private boolean[] used;
    
    private void dfs(List<List<Integer>> rooms, int curr) {
        if (used[curr]) return;
        used[curr] = true;
        cnt++;
        for (int next : rooms.get(curr))
            dfs(rooms, next);
    }
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> keys = new ArrayDeque<>();
        used = new boolean[rooms.size()];
        dfs(rooms, 0);
        return cnt == rooms.size();
    }
}