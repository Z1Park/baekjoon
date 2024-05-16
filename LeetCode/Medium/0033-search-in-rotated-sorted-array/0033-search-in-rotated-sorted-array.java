class Solution {
    
    private int findPivot(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) return start;
        int mid = (start + end) / 2;
        if (nums[start] > nums[mid]) return findPivot(nums, start, mid);
        return findPivot(nums, mid+1, end);
    }
    
    private int findValue(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        if (start >= nums.length || nums[start] != target)
            return -1;
        return start;
    }
    
    public int search(int[] nums, int target) {
        int end = nums.length - 1, pivot = findPivot(nums, 0, end);
        if (nums[end] >= target) return findValue(nums, pivot, end, target);
        return findValue(nums, 0, pivot-1, target);
    }
}