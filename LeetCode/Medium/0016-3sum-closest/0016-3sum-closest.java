class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length-2, result = Integer.MAX_VALUE, diff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int l = i+1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target-sum);
                    result = sum;
                }
                
                if (sum == target) return target;
                else if (sum < target) l++;
                else r--;
            }
        }
        return result;
    }
}