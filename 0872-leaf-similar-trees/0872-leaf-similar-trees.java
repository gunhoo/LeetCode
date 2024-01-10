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
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) { 
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if(list1.equals(list2)) return true;
        return false;
    }
    
    private void dfs(TreeNode tree, List<Integer> list) {
        if(tree.left == null && tree.right == null) {
            list.add(tree.val);
            return;
        }
        if(tree.left != null) {
            dfs(tree.left, list);
        }
        if(tree.right != null) {
            dfs(tree.right, list);
        }
    }
    
}