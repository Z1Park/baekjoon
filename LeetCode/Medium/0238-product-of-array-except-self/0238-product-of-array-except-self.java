class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCount++;
            else totalProduct *= nums[i];
        }
        
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                answer[i] = zeroCount == 1 ? totalProduct : 0;
            }
            else if (zeroCount != 0) answer[i] = 0;
            else answer[i] = totalProduct / nums[i];
        }
        return answer;
    }
}