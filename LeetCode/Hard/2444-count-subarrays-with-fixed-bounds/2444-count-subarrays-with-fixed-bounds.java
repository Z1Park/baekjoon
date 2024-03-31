class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;
        int minIndex = -1, maxIndex = -1, outIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) minIndex = i;
            if (nums[i] == maxK) maxIndex = i;
            if (nums[i] < minK || maxK < nums[i]) outIndex = i;
            count += Math.max(0L, Math.min(minIndex, maxIndex) - outIndex);
        }
        return count;
    }
}