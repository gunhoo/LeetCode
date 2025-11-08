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
    public int maxLevelSum(TreeNode root) {
        // Map that stores <level, sum of the level>
        // Stack that scores a class that contaisn TreeNode
        // while q is not empty, poll TreeLevel and update the map
        // iterate all map, find the biggest sum and return that level
        int maxSumLevel = 1, maxSum = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int currLevel = 0;
        while(!q.isEmpty()){
            int currStackSize = q.size();
            int currLevelSum = 0;
            currLevel += 1;
            for(int i=0; i<currStackSize; i++){
                TreeNode node = q.poll();
                currLevelSum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(currLevelSum > maxSum){
                maxSum = currLevelSum;
                maxSumLevel = currLevel;
            }
        }
        return maxSumLevel;
    }
}