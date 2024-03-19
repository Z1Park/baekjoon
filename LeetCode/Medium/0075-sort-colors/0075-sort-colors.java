class Solution {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++)
            colors[nums[i]]++;
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            while (colors[i] > 0) {
                nums[idx++] = i;
                colors[i]--;
            }
        }
    }
}