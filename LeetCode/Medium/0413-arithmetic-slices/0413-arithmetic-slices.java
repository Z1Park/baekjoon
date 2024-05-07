class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i-1] - nums[i-2] == nums[i] - nums[i-1]) {
                int diff = nums[i] - nums[i-1];
                int idx = i;
                while (idx < nums.length && nums[idx] - nums[idx-1] == diff) {
                    idx++;
                    count += idx - i;
                }
                i = idx;
            }
        }
        return count;
    }
}