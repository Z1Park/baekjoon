class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] counts = new int[20001];
        int offset = 10_000;
        
        for (int num : nums)
            counts[num + offset]++;
        for (int i = counts.length-1; i >= 0; i--) {
            k -= counts[i];
            if (k <= 0) return i - offset;
        }
        return 0;
    }
}