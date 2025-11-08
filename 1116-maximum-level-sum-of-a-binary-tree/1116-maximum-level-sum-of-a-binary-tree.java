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
        // Queue that scores a class that contaisn TreeNode, level
        // while q is not empty, poll TreeLevel and update the map
        // iterate all map, find the biggest sum and return that level
        int maxSumLevel = 1;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeLevel> q = new LinkedList<>();

        q.add(new TreeLevel(root, 1));

        while(!q.isEmpty()){
            TreeLevel tl = q.poll();
            map.put(tl.level, map.getOrDefault(tl.level, 0)+tl.tree.val);
            if(tl.tree.left != null){
                q.add(new TreeLevel(tl.tree.left, tl.level+1));
            }
            if(tl.tree.right != null){
                q.add(new TreeLevel(tl.tree.right, tl.level+1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > map.get(maxSumLevel)){
                maxSumLevel = entry.getKey();
            }
        }
        return maxSumLevel;
    }

    class TreeLevel{
        TreeNode tree;
        int level;
        
        public TreeLevel(TreeNode t, int l){
            this.tree = t;
            this.level = l;
        }
    }
}