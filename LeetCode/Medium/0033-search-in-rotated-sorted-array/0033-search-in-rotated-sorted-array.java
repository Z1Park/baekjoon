class Solution {
    
    private int getRotatedIndex(int[] nums, int s, int e) {
        if (nums[s] < nums[e]) return e+1;
        if (s == e) return e;
        if (e - s == 1 && nums[s] > nums[e]) return e;
        int mid = (s + e) / 2;
        if (nums[s] > nums[mid]) return getRotatedIndex(nums, s, mid);
        else return getRotatedIndex(nums, mid, e);
    }
    
    private int binarySearch(int[] nums, int target, int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        return s;
    }
    
    public int search(int[] nums, int target) {
        int rot = getRotatedIndex(nums, 0, nums.length-1);
        int idx = binarySearch(nums, target, 0, rot-1);
        if (idx >= rot || nums[idx] != target)
            idx = binarySearch(nums, target, rot, nums.length-1);
        if (idx >= nums.length || nums[idx] != target)
            idx = -1;
        return idx;
    }
}