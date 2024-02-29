class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, count = 0, maxValue = 0;
        while (r < nums.length) {
            if (nums[r] == 1) {
                count++;
                r++;
            }
            else {
                if (k > 0) {
                    r++;
                    k--;
                    count++;
                }
                else {
                    while (nums[l] == 1)
                        l++;
                    l++;
                    r++;
                    count = r - l;
                }
            }
            if (maxValue < count)
                maxValue = count;
        }
        return maxValue;
    }
}