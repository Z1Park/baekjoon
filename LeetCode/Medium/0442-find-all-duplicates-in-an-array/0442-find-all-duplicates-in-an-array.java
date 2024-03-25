class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        boolean[] appeared = new boolean[100_001];
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (appeared[num]) result.add(num);
            else appeared[num] = true;
        }
        return result;
    }
}