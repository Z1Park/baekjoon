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
    
    private void invertNode(TreeNode node) {
        if (node == null) return;
        TreeNode tmp = node.left;
        if (node.left != null) invertNode(node.left);
        if (node.right != null) invertNode(node.right);
        node.left = node.right;
        node.right = tmp;
    }
    
    public TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }
}