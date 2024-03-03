class Solution {
    
    private List<List<Integer>> combinations = new ArrayList<>();
    
    private void getCombination(int[] nums, List<Integer> buffer, int len, int curr) {
        if (buffer.size() >= len) {
            combinations.add(List.copyOf(buffer));
            return;
        }
        for (int i = curr; i < nums.length; i++) {
            buffer.add(nums[i]);
            getCombination(nums, buffer, len, i+1);
            buffer.remove(buffer.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> buffer = new ArrayList<>();
        
        for (int i = 0; i <= nums.length; i++)
            getCombination(nums, buffer, i, 0);
        return combinations;
    }
}