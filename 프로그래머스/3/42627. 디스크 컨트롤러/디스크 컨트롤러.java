import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparing((int[] arr) -> arr[0])
                   .thenComparing((int[] arr) -> arr[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        int idx = 0, currTime = 0, res = 0;
        while (idx < jobs.length || !pq.isEmpty()) {
            if (pq.isEmpty()) pq.add(jobs[idx++]);
            int[] job = pq.poll();
            if (currTime < job[0]) currTime = job[0];
            int endTime = currTime + job[1];
            res += endTime - job[0];
            while (idx < jobs.length && jobs[idx][0] < endTime) {
                pq.add(jobs[idx++]);
            }
            currTime = endTime;
        }
        return res / jobs.length;
    }
}