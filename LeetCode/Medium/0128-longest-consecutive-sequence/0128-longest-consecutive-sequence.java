class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int l = map.getOrDefault(num-1, 0), r = map.getOrDefault(num+1, 0);
            int length = l + r + 1;
            res = Math.max(res, length);
            
            map.put(num, length);
            map.put(num - l, length);
            map.put(num + r, length);
        }
        return res;
    }
}