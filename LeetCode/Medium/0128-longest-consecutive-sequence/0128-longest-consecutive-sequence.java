class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 1000) {
            Arrays.sort(nums);
            int maxCount = 1, count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]+1) count++;
                else if (nums[i] - nums[i-1] > 1) count = 1;
                if (maxCount < count) maxCount = count;
            }
            return maxCount;
        }
        else {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (min > nums[i]) min = nums[i];
                if (max < nums[i]) max = nums[i];
            }
            
            boolean[] exist = new boolean[max - min + 1];
            for (int i = 0; i < nums.length; i++)
                exist[nums[i]-min] = true;
            int maxCount = 0, count = 0;
            for (int i = 0; i < max - min + 1; i++) {
                if (exist[i]) count++;
                else count = 0;
                if (maxCount < count) maxCount = count;
            }
            return maxCount;
        }
    }
}