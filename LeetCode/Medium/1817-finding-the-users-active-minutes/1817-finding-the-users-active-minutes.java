class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.computeIfAbsent(log[0], v -> new HashSet<>())
                .add(log[1]);
        }
        
        int[] result = new int[k];
        for (Set<Integer> set : map.values())
            result[set.size()-1]++;
        return result;
    }
}