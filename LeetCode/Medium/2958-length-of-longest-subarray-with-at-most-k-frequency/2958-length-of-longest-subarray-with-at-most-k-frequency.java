class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            countMap.put(nums[r], countMap.getOrDefault(nums[r], 0) + 1);
            while (countMap.get(nums[r]) > k)
                countMap.put(nums[l], countMap.get(nums[l++]) - 1);
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}