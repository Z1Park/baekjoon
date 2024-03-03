class Solution {
    
    private List<List<Integer>> permutations = new ArrayList<>();
    
    private void getPermutation(Set<Integer> used, int[] nums) {
        if (used.size() >= nums.length) {
            permutations.add(new ArrayList<>(used));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                used.add(nums[i]);
                getPermutation(used, nums);
                used.remove(nums[i]);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        getPermutation(new LinkedHashSet<>(), nums);
        return permutations;
    }
}