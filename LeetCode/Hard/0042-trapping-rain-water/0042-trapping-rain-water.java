class Solution {
    public int trap(int[] height) {
        int maxIndex = -1, maxValue = Integer.MIN_VALUE;
        for (int i = 0 ; i < height.length; i++) {
            if (maxValue < height[i]) {
                maxIndex = i;
                maxValue = height[i];
            }
        }
        
        int currMax = height[0], sum = 0;
        for (int i = 1; i < maxIndex; i++) {
            if (currMax <= height[i]) currMax = height[i];
            else sum += currMax - height[i];
        }
        
        currMax = height[height.length-1];
        for (int i = height.length-1; i > maxIndex; i--) {
            if (currMax <= height[i]) currMax = height[i];
            else sum += currMax - height[i];
        }
        return sum;
    }
}