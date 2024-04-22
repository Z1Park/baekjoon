class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int count = 0;
        for (int[] trip : trips) {
            while (!que.isEmpty() && que.peek()[0] <= trip[1])
                count -= que.poll()[1];
            if (count + trip[0] > capacity)
                return false;
            count += trip[0];
            que.add(new int[]{trip[2], trip[0]});
        }
        return true;
    }
}