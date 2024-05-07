class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] diff = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++)
            diff[i-1] = nums[i] - nums[i-1];
        
        int count = 0, curr = 0;
        for (int i = 1; i < diff.length; i++) {
            if (diff[i-1] == diff[i]) {
                curr++;
                count += curr;
            }
            else curr = 0;
        }
        return count;
    }
}