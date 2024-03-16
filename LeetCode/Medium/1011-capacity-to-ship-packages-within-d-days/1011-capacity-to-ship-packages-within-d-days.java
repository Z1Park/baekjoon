class Solution {
    
    private int getDeliveryDays(int[] weights, int limit) {
        int count = 1, stack = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > limit)
                return Integer.MAX_VALUE;
            if (stack + weights[i] <= limit) 
                stack += weights[i];
            else {
                count++;
                stack = weights[i];
            }
        }
        return count;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int start = 1, end = 50000 * 500;
        while (start <= end) {
            int mid = start / 2 + (end + start % 2) / 2;
            if (days < getDeliveryDays(weights, mid))
                start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}