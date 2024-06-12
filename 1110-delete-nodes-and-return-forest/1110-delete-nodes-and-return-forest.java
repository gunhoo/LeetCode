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
    private List<TreeNode> ans;
    private Set<Integer> delNumSet;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new LinkedList<>();
        delNumSet = new HashSet<>();
        for(int num : to_delete) delNumSet.add(num);
        recur(root, true);
        return ans;
    }
    
    private TreeNode recur(TreeNode node, boolean isRoot){
        if(node == null) return null;
        boolean deleted = delNumSet.contains(node.val);
        if(!deleted && isRoot) ans.add(node);
        node.left = recur(node.left, deleted);
        node.right = recur(node.right, deleted);
        return deleted? null : node;
    }
}