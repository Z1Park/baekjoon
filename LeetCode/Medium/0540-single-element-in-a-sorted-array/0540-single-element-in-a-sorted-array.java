class Solution {
    
    private int checkAllFilled(int[] nums, int idx) {
        int sameIdx = -1;
        if (idx > 0 && nums[idx-1] == nums[idx])
            sameIdx = idx-1;
        else if (idx < nums.length - 1 && nums[idx] == nums[idx+1]) {
            sameIdx = idx;
            idx++;
        }
        
        if (sameIdx == -1) return 0;
        if (sameIdx % 2 == 0) return 1;
        else return -1;
    }
    
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int tmp = checkAllFilled(nums, mid);
            if (tmp == 0) return nums[mid];
            else if (tmp > 0) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }
}