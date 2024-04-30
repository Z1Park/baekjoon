class Solution {
    
    private boolean isOnLeft(int[] nums, int idx) {
        if (idx == 0) return nums[idx] != nums[idx+1];
        if (idx == nums.length - 1) return true;
        
        int left;
        if (nums[idx] == nums[idx-1])
            left = idx - (nums[idx] == nums[idx+1] ? 1 : 2);
        else if (nums[idx] == nums[idx+1]) left = idx;
        else return true;
        return left % 3 != 0;
    }
    
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isOnLeft(nums, mid)) end = mid - 1;
            else start = mid + 1;
        }
        return nums[start];
    }
}