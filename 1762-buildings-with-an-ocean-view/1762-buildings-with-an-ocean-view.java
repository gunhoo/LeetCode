class Solution {
    public int[] findBuildings(int[] heights) {
        int height = heights[heights.length-1];
        List<Integer> list = new ArrayList<>();
        list.add(heights.length-1);
        for(int i=heights.length-1; i>=0; i--){
            if(heights[i] > height){
                list.add(i);
                height = heights[i];
            } 
        }
        Collections.sort(list);
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}