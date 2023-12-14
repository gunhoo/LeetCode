class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[][] diff = new int[grid.length][grid[0].length];
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                rows[i] += grid[i][j] == 1 ? 1: -1;
            }
        }
        for (int i=0; i<grid[0].length; i++) {
            for(int j=0; j<grid.length; j++) {
                cols[i] += grid[j][i] == 1? 1 : -1;
            }
        }
        
        for (int i=0; i<diff.length; i++) {
            for(int j=0; j<diff[0].length; j++) {
                diff[i][j] = rows[i] + cols[j];
            }
        }
        return diff;
    }
}