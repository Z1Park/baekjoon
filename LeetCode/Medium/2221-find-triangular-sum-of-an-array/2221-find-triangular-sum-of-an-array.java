class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length;
        while (len > 1) {
            for (int i = 1; i < len; i++)
                nums[i-1] = (nums[i-1] + nums[i]) % 10;
            len--;
        }
        return nums[0];
    }
}