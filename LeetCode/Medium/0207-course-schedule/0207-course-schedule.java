class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        
        for (int[] pr : prerequisites) {
            counts[pr[0]]++;
            graph[pr[1]].add(pr[0]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (counts[i] == 0) que.add(i);
        }
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int next : graph[curr]) {
                counts[next]--;
                if (counts[next] == 0) que.add(next);
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (counts[i] != 0) return false;
        }
        return true;
    }
}