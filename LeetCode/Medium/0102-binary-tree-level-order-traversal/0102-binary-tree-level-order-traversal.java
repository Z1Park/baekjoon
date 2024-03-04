/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private class Data {
        public TreeNode node;
        public int level;
        
        public Data(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<Data> dq = new ArrayDeque<>();
        dq.add(new Data(root, 1));
        while (!dq.isEmpty()) {
            Data data = dq.poll();
            if (result.size() < data.level)
                result.add(new ArrayList<>());
            result.get(data.level-1).add(data.node.val);
            if (data.node.left != null)
                dq.add(new Data(data.node.left, data.level+1));
            if (data.node.right != null)
                dq.add(new Data(data.node.right, data.level+1));
        }
        return result;
    }
}