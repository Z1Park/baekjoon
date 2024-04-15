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
    
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        makeNumber(root, 0);
        return sum;
    }
    
    private void makeNumber(TreeNode node, int curr) {
        curr = curr * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += curr;
            return;
        }
        if (node.left != null) makeNumber(node.left, curr);
        if (node.right != null) makeNumber(node.right, curr);
    }
}