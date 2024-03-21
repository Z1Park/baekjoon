class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (!map.containsKey(t)) continue;
            List<Integer> list = map.get(t);
            for (int idx : list) {
                if (idx > i) return new int[]{i, idx};
                else if (idx < i) return new int[]{idx, i};
            }
        }
        return new int[]{};
    }
}