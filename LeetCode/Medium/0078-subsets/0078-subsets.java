class Solution {
    
    private List<List<Integer>> combinations = new ArrayList<>();
    
    private void getCombination(int[] nums, List<Integer> buffer, int curr) {
        combinations.add(new ArrayList<>(buffer));
        
        for (int i = curr; i < nums.length; i++) {
            buffer.add(nums[i]);
            getCombination(nums, buffer, i+1);
            buffer.remove(buffer.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> buffer = new ArrayList<>();
        getCombination(nums, buffer, 0);
        return combinations;
    }
}