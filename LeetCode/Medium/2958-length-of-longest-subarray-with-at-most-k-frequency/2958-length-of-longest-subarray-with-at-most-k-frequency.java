class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        for (int l = 0, r = 0; l < nums.length; l++) {
            while (r < nums.length && countMap.getOrDefault(nums[r], 0) < k) {
                countMap.put(nums[r], countMap.getOrDefault(nums[r], 0) + 1);
                r++;
            }
            result = Math.max(result, r - l);
            countMap.put(nums[l], countMap.get(nums[l]) - 1);
        }
        return result;
    }
}