class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int i = 1; i < n; i++) {
            triangle.get(i).set(0, triangle.get(i).get(0) + 
                                triangle.get(i-1).get(0));
            for (int j = 1; j < i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + 
                                    Math.min(triangle.get(i-1).get(j-1), 
                                            triangle.get(i-1).get(j)));
            triangle.get(i).set(i, triangle.get(i).get(i) + 
                                triangle.get(i-1).get(i-1));
        }
        
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            minValue = Math.min(triangle.get(n-1).get(i), minValue);
        return minValue;
    }
}