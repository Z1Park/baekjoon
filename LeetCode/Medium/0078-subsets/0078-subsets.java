class Solution {
    
    private List<List<Integer>> combinations = new ArrayList<>();
    
    private void getCombination(int[] nums, List<Integer> buffer, boolean[] used, int len, int curr) {
        if (buffer.size() >= len) {
            combinations.add(List.copyOf(buffer));
            return;
        }
        for (int i = curr; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                buffer.add(nums[i]);
                getCombination(nums, buffer, used, len, i+1);
                buffer.remove(buffer.size()-1);
                used[i] = false;
            }
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> buffer = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        for (int i = 0; i <= nums.length; i++)
            getCombination(nums, buffer, used, i, 0);
        return combinations;
    }
}