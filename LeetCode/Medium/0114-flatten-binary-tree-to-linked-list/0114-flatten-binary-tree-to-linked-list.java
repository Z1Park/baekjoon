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
    
    private Queue<TreeNode> que = new LinkedList<>();
    
    private void visit(TreeNode node) {
        if (node == null) return;
        que.add(node);
        visit(node.left);
        visit(node.right);
    }
    
    private void rearrange(TreeNode node) {
        que.poll();
        while (!que.isEmpty()) {
            node.left = null;
            node.right = que.poll();
            node = node.right;
        }
    }
    
    public void flatten(TreeNode root) {
        visit(root);
        rearrange(root);
    }
}