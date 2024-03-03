class Solution {
    
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> buffer = new ArrayList<>();
    private int sum = 0;
    
    
    private void dfs(int[] candidates, int target, int start) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(buffer));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            buffer.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, target, i);
            buffer.remove(buffer.size() - 1);
            sum -= candidates[i];
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }
}