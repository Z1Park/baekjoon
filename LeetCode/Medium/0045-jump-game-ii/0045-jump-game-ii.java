class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int maxReach = 0, current = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == current) {
                current = maxReach;
                count++;
            }
        }
        return count;
    }
}