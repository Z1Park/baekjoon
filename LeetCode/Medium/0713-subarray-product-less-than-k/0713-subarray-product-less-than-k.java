class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int l = 0; l < nums.length; l++) {
            int r = l, prod = 1;
            while (r < nums.length && prod * nums[r] < k) {
                prod *= nums[r++];
                count++;
            }
        }
        return count;
    }
}