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
    int postorderIdx;
    Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length-1;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return arrayToTree(postorder, 0, inorder.length-1);
    }
    
    private TreeNode arrayToTree(int[] postorder, int left, int right){
        if(left>right) return null;
        int rootValue = postorder[postorderIdx];
        TreeNode root = new TreeNode(rootValue);
        
        postorderIdx--;
            
        root.right = arrayToTree(postorder, map.get(rootValue)+1, right);
        root.left = arrayToTree(postorder, left, map.get(rootValue)-1);
        
        return root;
    }
}