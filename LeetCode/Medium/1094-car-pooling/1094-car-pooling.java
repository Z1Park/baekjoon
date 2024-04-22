class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] prefix = new int[1001];
        for (int[] trip : trips) {
            prefix[trip[1]] += trip[0];
            prefix[trip[2]] -= trip[0];
        }
        
        if (prefix[0] > capacity) return false;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i-1];
            if (prefix[i] > capacity)
                return false;
        }
        return true;
    }
}