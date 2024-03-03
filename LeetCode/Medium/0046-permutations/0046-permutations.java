class Solution {
    
    private List<List<Integer>> permutations = new ArrayList<>();
    
    private void getPermutation(boolean[] used, List<Integer> list, int[] nums) {
        if (list.size() >= nums.length) {
            permutations.add(List.copyOf(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                getPermutation(used, list, nums);
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        getPermutation(new boolean[nums.length], new ArrayList<>(), nums);
        return permutations;
    }
}