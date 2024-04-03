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
    
    private List<Integer> sums = new ArrayList<>();
    
    private void calculateSum(TreeNode node, int level) {
        if (sums.size() <= level) sums.add(node.val);
        else sums.set(level, sums.get(level) + node.val);
        
        if (node.left != null) calculateSum(node.left, level+1);
        if (node.right != null) calculateSum(node.right, level+1);
    }
    
    public int deepestLeavesSum(TreeNode root) {
        calculateSum(root, 0);
        return sums.get(sums.size()-1);
    }
}