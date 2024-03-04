class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] counts = new int[20002];
        int offset = 10000;
        for (int i = 0; i < nums.length; i++)
            counts[offset + nums[i]]++;
        int i = counts.length-1;
        for (; k > 0; i--)
            k -= counts[i];
        return i - offset + 1;
    }
}