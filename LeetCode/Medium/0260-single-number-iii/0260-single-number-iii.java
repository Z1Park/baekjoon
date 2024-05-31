class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) return nums;
        Arrays.sort(nums);
        int[] result = new int[2];
        int i = 0, idx = 0, n = nums.length;
        while (i < n) {
            if (i < n - 1 && nums[i] == nums[i+1]) i += 2;
            else result[idx++] = nums[i++];
        }
        return result;
    }
}