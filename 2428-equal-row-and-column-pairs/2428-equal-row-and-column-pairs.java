class Solution {
    public int equalPairs(int[][] grid) {
        int totalEqualPairs=0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<grid.length; i++){
            String rowString = Arrays.toString(grid[i]);
            map.put(rowString, map.getOrDefault(rowString, 0)+1);
        }
        for(int i=0; i<grid.length; i++){
            int[] col = new int[grid.length];
            for(int j=0; j<grid.length; j++){
                col[j] = grid[j][i];
            }
            totalEqualPairs += map.getOrDefault(Arrays.toString(col),0);
        }
        return totalEqualPairs;
    }
}