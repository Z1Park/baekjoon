class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxValue = (right - left) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right]) left++;
            else right--;
            int area = (right - left) * Math.min(height[left], height[right]);
            if (maxValue < area)
                maxValue = area;
        }
        return maxValue;
    }
}