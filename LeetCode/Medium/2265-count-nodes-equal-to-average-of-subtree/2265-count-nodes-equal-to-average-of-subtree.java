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
    
    private int result = 0;
    
    private int[] rec(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        
        int[] left = rec(node.left);
        int[] right = rec(node.right);
        int count = left[0] + right[0] + 1;
        int sum = left[1] + right[1] + node.val;
        if (node.val == sum / count) result++;
        
        return new int[]{count, sum};
    }
    
    public int averageOfSubtree(TreeNode root) {
        rec(root);
        return result;
    }
}