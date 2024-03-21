class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        int maxLength = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxLength) break;
            maxLength = Math.max(maxLength, i + nums[i]);
        }
        return maxLength >= nums.length-1;
    }
}