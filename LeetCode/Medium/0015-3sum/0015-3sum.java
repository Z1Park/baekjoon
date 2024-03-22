class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int size = nums.length - 2;
        for (int i = 0; i < size; i++) {
            int l = i+1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                }
                else if (sum < 0) l++;
                else r--;
            }
        }
        return result.stream().toList();
    }
}