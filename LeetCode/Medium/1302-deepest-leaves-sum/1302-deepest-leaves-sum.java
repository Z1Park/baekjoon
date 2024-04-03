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
    
    private int maxLevel = -1;
    private int sum = 0;
    
    private void calculateSum(TreeNode node, int level) {
        if (maxLevel < level) {
            maxLevel = level;
            sum = node.val;
        }
        else if (maxLevel == level) sum += node.val;
        
        if (node.left != null) calculateSum(node.left, level+1);
        if (node.right != null) calculateSum(node.right, level+1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        calculateSum(root, 0);
        return sum;
    }
}