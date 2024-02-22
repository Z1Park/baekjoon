import java.util.*;

class Solution {
    
    class Node {
        private int n;
        private int x, y;
        private Node left;
        private Node right;
        
        public Node(int[] arr) {
            this.n = arr[0];
            this.x = arr[1];
            this.y = arr[2];
        }
        
        public String toString() {
            return n + " : " + x + " / " + y;
        }
    }
    
    private Node root;
    
    private void insertTree(Node node) {
        if (root == null) {
            root = node;
            return;
        }
        Node curr = root, prev = root;
        while (curr != null && curr.y > node.y) {
            prev = curr;
            if (curr.x > node.x) curr = curr.left;
            else curr = curr.right;
        }
        if (prev.x > node.x) prev.left = node;
        else prev.right = node;
    }
    
    private void getPreOrder(List<Integer> tmp, Node node) {
        tmp.add(node.n);
        if (node.left != null) getPreOrder(tmp, node.left);
        if (node.right != null) getPreOrder(tmp, node.right);
    }
    
    private void getPostOrder(List<Integer> tmp, Node node) {
        if (node.left != null) getPostOrder(tmp, node.left);
        if (node.right != null) getPostOrder(tmp, node.right);
        tmp.add(node.n);
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing((int[] arr) -> -arr[2])
                    .thenComparing((int[] arr) -> arr[1]));
        for (int i = 0; i < nodeinfo.length; i++)
            pq.add(new int[]{i+1, nodeinfo[i][0], nodeinfo[i][1]});
        
        while (!pq.isEmpty()) {
            insertTree(new Node(pq.poll()));
        }
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        getPreOrder(tmp, root);
        res.add(List.copyOf(tmp));
        tmp.clear();
        getPostOrder(tmp, root);
        res.add(List.copyOf(tmp));
        
        return res.stream()
            .map(arr -> arr.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);
    }
}