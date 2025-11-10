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
    public boolean isValidBST(TreeNode root) {
        // DFS
        if(root.left == null && root.right == null) return true;
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(Integer.MIN_VALUE);
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long min, long max){
        if(root.val <= min || root.val >= max) return false;
        if(root.left == null && root.right == null) return true;
        boolean leftValid = true;
        boolean rightValid = true;

        if(root.right != null){
            rightValid = helper(root.right, Math.max(min, root.val), max);
        }
        if(root.left != null){
            leftValid = helper(root.left, min, Math.min(max, root.val));
        }
        return leftValid && rightValid;
    }
}