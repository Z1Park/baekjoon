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
    public int sumNumbers(TreeNode root) {
        return makeNumber(root, 0);
    }
    
    private int makeNumber(TreeNode node, int curr) {
        if (node == null) return 0;
        curr = curr * 10 + node.val;
        if (node.left == null && node.right == null) return curr;
        return makeNumber(node.left, curr) + makeNumber(node.right, curr);
    }
}