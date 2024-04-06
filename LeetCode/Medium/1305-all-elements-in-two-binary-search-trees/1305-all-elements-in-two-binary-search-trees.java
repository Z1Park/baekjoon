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
    
    private void addList(List<Integer> elem, TreeNode node) {
        if (node == null) return;
        if (node.left != null) addList(elem, node.left);
        elem.add(node.val);
        if (node.right != null) addList(elem, node.right);
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> elem1 = new ArrayList<>();
        List<Integer> elem2 = new ArrayList<>();
        
        addList(elem1, root1);
        addList(elem2, root2);
        
        int idx1 = 0, idx2 = 0;
        List<Integer> result = new ArrayList<>();
        while (idx1 < elem1.size() || idx2 < elem2.size()) {
            if (idx1 >= elem1.size()) result.add(elem2.get(idx2++));
            else if (idx2 >= elem2.size()) result.add(elem1.get(idx1++));
            else if (elem1.get(idx1) > elem2.get(idx2))
                result.add(elem2.get(idx2++));
            else result.add(elem1.get(idx1++));
        }
        return result;
    }
}