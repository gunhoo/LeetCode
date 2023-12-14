class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                rows[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = 2*rows[i] + 2*cols[j] - n - m;
            }
        }
        
        return grid;
    }
}