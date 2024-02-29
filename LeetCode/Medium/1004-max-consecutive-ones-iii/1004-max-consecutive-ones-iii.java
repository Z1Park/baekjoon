class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxValue = 0, count = 0;
        if (k == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) count = 0;
                else count++;
                if (maxValue < count)
                    maxValue = count;
            }
            return maxValue;
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (que.size() >= k) {
                    int front = que.poll();
                    count = i - front - 1;
                }
                que.add(i);
                count++;
            }
            else {
                count++;
            }
            if (count > maxValue)
                maxValue = count;
        }
        return maxValue;
    }
}