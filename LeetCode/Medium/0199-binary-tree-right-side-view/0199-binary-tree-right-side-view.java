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
    
    private boolean[] visit = new boolean[101];
    private List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        getRightView(root, 0);
        return result;
    }
    
    private void getRightView(TreeNode node, int level) {
        if (node == null) return;
        
        if (!visit[level]) result.add(node.val);
        visit[level] = true;
        getRightView(node.right, level + 1);
        getRightView(node.left, level + 1);
    }
}