class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int last = 0, count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[last][1]) {
                last = i;
                count++;
            }
        }
        return count;
    }
}