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
        
        boolean[] visit = new boolean[numCourses];
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (counts[i] == 0) {
                visit[i] = true;
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int next : graph[curr]) {
                counts[next]--;
                if (counts[next] == 0 && !visit[next]) {
                    que.add(next);
                    visit[next] = true;
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (!visit[i]) return false;
        }
        return true;
    }
}