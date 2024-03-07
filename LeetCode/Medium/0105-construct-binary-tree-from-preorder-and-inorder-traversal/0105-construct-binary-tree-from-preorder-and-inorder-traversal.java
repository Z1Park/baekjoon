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
    
    private Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return makeNode(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode makeNode(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode node = new TreeNode(preorder[preStart]);
        int rootPosition = map.get(node.val);
        int leftArange = rootPosition - inStart;
        
        node.left = makeNode(preorder, inorder, preStart+1, preStart + leftArange, inStart, rootPosition-1);
        node.right = makeNode(preorder, inorder, preStart + leftArange + 1, preEnd, rootPosition+1, inEnd);
        return node;
    }
}