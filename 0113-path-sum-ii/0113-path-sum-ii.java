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
    private List<List<Integer>> answer;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        answer = new ArrayList<>();
        findSum(root, new ArrayList<>(), targetSum);
        return answer;
    }

    private void findSum(TreeNode root, List<Integer> list, int targetSum){
        if(root == null) return;
        list.add(root.val);
        if(root.val == targetSum && root.left == null && root.right == null){
            answer.add(new ArrayList<>(list));
        } else{
            findSum(root.left, list, targetSum-root.val);
            findSum(root.right, list, targetSum-root.val);
        }
        list.remove(list.size()-1);
    }
}