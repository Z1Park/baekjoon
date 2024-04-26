class Solution {
    
    private int checkAllFilled(int[] nums, int idx) {
        if (idx > 0 && nums[idx-1] == nums[idx])
            idx--;
        else if (idx >= nums.length - 1 || nums[idx] != nums[idx+1])
            return 0;
        return (idx % 2 == 0 ? 1 : -1);
    }
    
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (checkAllFilled(nums, mid) > 0) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }
}