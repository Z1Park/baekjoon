class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] mods = new int[k+1];
        mods[0]++;
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (sum < 0) sum += k;
            count += mods[sum];
            mods[sum]++;
        }
        return count;
    }
}