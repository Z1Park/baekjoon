class Solution {
    public int findDuplicate(int[] nums) {
        int[] counts = new int[100001];
        for (int num : nums) {
            counts[num]++;
            if (counts[num] > 1) return num;
        }
        return -1;
    }
}