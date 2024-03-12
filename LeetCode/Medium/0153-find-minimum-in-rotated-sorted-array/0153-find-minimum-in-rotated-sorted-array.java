class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length-1]) return nums[0];
        int l = 1, r = nums.length-1, prev = nums[0];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > prev) l = mid + 1;
            else r = mid - 1;
        }
        return nums[l];
    }
}