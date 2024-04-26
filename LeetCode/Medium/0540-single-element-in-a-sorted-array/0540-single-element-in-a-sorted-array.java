class Solution {
    
    private boolean checkAllFilled(int[] nums, int idx) {
        if (idx > 0 && nums[idx-1] == nums[idx]) idx--;
        return idx % 2 == 0;
    }
    
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (checkAllFilled(nums, mid)) start = mid + 1;
            else end = mid - 1;
        }
        return nums[end];
    }
}