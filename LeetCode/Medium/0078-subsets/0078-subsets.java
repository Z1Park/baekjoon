class Solution {

    private void getCombination(List<List<Integer>> combinations, int[] nums, List<Integer> buffer, int curr) {
        combinations.add(List.copyOf(buffer));
        
        for (int i = curr; i < nums.length; i++) {
            buffer.add(nums[i]);
            getCombination(combinations, nums, buffer, i+1);
            buffer.remove(buffer.size()-1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        getCombination(combinations, nums, new ArrayList<>(), 0);
        return combinations;
    }
}