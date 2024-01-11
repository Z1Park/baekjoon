import java.util.*;

class Solution {
    
    private List<List<Integer>> graph = new ArrayList<>();
    
    private void saveGraph(int[][] edges) {
        for (int[] edge : edges) {
            while (graph.size() <= edge[0] || graph.size() <= edge[1]) {
                graph.add(new ArrayList<>());
                graph.get(graph.size()-1).add(0);
            }
            graph.get(edge[0]).add(edge[1]);
            int cnt = graph.get(edge[1]).get(0);
            graph.get(edge[1]).set(0, cnt+1);
        }
    }
    
    private int getNewNode() {
        int newNode = -1, cnt = 0;
        for (int i = 0; i < graph.size(); i++) {
            List<Integer> node = graph.get(i);
            int input = node.get(0), output = node.size() - 1;
            if (input != 0) continue;
            if (cnt < output) {
                newNode = i;
                cnt = output;
            }
        }
        return newNode;
    }
    
    private void removeNode(int nodeIdx) {
        List<Integer> node = graph.get(nodeIdx);
        for (int i = 1; i < node.size(); i++) {
            int tmp = node.get(i);
            int cnt = graph.get(tmp).get(0);
            graph.get(tmp).set(0, cnt - 1);
        }
        node.clear();
        node.add(0);
    }
    
    private boolean rotateGraph(int node, boolean[] visit) {
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        visit[node] = true;
        boolean isDounut = false;
        while (!que.isEmpty()) {
            int curr = que.poll();
            List<Integer> nextNodes = graph.get(curr);
            if (nextNodes.get(0) == 2) isDounut = true;
            for (int j = 1; j < nextNodes.size(); j++) {
                int next = nextNodes.get(j);
                if (visit[next]) continue;
                visit[next] = true;
                que.add(next);
            }
        }
        return isDounut;
    }
    
    private int findStickGraph(boolean[] visit) {
        int cnt = 0;
        for (int i = 1; i < graph.size(); i++) {
            if (visit[i]) continue;
            if (graph.get(i).get(0) == 0) {
                cnt++;
                rotateGraph(i, visit);
            }
        }
        return cnt;
    }
    
    public int[] solution(int[][] edges) {
        saveGraph(edges);
        int newNode = getNewNode();
        removeNode(newNode);
        
        boolean[] visit = new boolean[graph.size()];
        visit[newNode] = true;
        int[] answer = new int[]{newNode, 0, 0, 0};
        
        answer[2] = findStickGraph(visit);
        for (int i = 1; i < graph.size(); i++) {
            if (visit[i]) continue;
            if (rotateGraph(i, visit)) answer[3]++;
            else answer[1]++;
        }
        return answer;
    }
}