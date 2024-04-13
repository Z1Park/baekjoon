class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        
        int[] result = new int[n];
        int leftCount = 0, rightCount = 0;
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                rightCount++;
                rightSum += i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            result[i] = leftSum + rightSum;
            if (boxes.charAt(i) == '1') {
                leftCount++;
                rightCount--;
            }
            rightSum -= rightCount;
            leftSum += leftCount;
        }
        
        return result;
    }
}