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
    class Point{
        TreeNode t;
        int i;
        public Point(TreeNode t, int i){
            this.t = t;
            this. i = i;
        }
    }
    private Map<Integer, List<Integer>> map = new HashMap<>();
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(root, 0));
        
        while(!q.isEmpty()){
            Point p = q.poll();
            if(map.containsKey(p.i)){
                map.get(p.i).add(p.t.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p.t.val);
                map.put(p.i, list);
            }
            if(min > p.i) min = p.i;
            if(max < p.i) max = p.i;
            if(p.t.left != null){
                q.add(new Point(p.t.left, p.i-1));
            }
            if(p.t.right != null){
                q.add(new Point(p.t.right, p.i+1));
            }
        }
        
        for(int i=min; i<=max; i++){
            if(map.containsKey(i))
            ans.add(map.get(i));
        }
        
        System.out.println(map.entrySet());
        
        return ans;
    }
}