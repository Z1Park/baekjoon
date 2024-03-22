class Solution {
    
    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int size = nums.length - 2;
        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int sum = 0, limit = nums.length;
            for (int j = i+1; j < limit; j++) {
                sum = nums[i] + nums[j];
                int idx = binarySearch(nums, j+1, limit-1, -sum);
                if (j < idx && idx < limit && sum + nums[idx] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[idx]));
                    limit = idx;
                }
            }
        }
        return new ArrayList<>(result);
    }
}