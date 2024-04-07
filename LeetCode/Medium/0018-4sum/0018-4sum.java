class Solution {
    
    private Set<List<Integer>> result = new HashSet<>();
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length - 3;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            threeSum(nums, i, target - nums[i]);
        }
        return new ArrayList<>(result);
    }
    
    private void threeSum(int[] nums, int idx, int target) {
        int len = nums.length - 2, start = idx+1;
        for (int i = start; i < len; i++) {
            if (i != start && nums[i] == nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            while (l < r) {
                long sum = (long)nums[i] + nums[l] + nums[r];
                if (sum == target)
                    result.add(Arrays.asList(nums[idx], nums[i], nums[l], nums[r]));
                
                if (sum < target) l++;
                else r--;
            }
        }
    }
}