class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] a) -> a[0])
                   .thenComparing((int[] a) -> -a[1]));
        
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            else if (end < intervals[i][1]) end = intervals[i][1];
        }
        result.add(new int[]{start, end});
        return result.stream().toArray(int[][]::new);
    }
}