class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, product = 1;
        for (int l = 0, r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (product >= k && l <= r)
                product /= nums[l++];
            count += r - l + 1;
        }
        return count;
    }
}