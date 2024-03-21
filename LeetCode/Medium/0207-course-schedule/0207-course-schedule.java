class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] counts = new int[numCourses];
        for (int i = 0; i <  numCourses; i++)
            graph.add(new ArrayList<>());
        for (int[] e : prerequisites) {
            graph.get(e[0]).add(e[1]);
            counts[e[1]]++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0)
                que.add(i);
        }
        while (!que.isEmpty()) {
            int course = que.poll();
            for (int next : graph.get(course)) {
                if (--counts[next] == 0)
                    que.add(next);
            }
        }
        if (!que.isEmpty()) return false;
        for (int i = 0; i < counts.length; i++)
            if (counts[i] != 0) return false;
        return true;
    }
}