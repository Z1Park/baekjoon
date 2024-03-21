class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i <  numCourses; i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(0);
        }
        for (int[] e : prerequisites) {
            graph[e[0]].add(e[1]);
            graph[e[1]].set(0, graph[e[1]].get(0)+1);
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].get(0) == 0)
                que.add(i);
        }
        if (que.isEmpty()) return false;
        while (!que.isEmpty()) {
            int course = que.poll();
            for (int i = graph[course].size()-1; i > 0; i--) {
                int next = graph[course].get(i);
                graph[course].remove(i);
                graph[next].set(0, graph[next].get(0)-1);
                if (graph[next].get(0) == 0)
                    que.add(next);
            }
        }
        if (!que.isEmpty()) return false;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() != 1) return false;
        }
        return true;
    }
}