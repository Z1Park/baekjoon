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
    
    private int cnt = 0;
    
    private int prefixSequence(TreeNode node, int k) {
        int res = -1;
        if (node.left != null)
            res = prefixSequence(node.left, k);
        if (res != -1) return res;
        if (++cnt == k) return node.val;
        if (node.right != null)
            res = prefixSequence(node.right, k);
        return res;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        return prefixSequence(root, k);
    }
}