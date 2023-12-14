class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
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
        
        for (int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                grid[i][j] = rows[i] + cols[j];
            }
        }
        return grid;
//         int m = grid.length;
//         int n = grid[0].length;
//         int[][] diff = new int[m][n];
//         int[] rows = new int[m];
//         int[] cols = new int[n];
        
//         for (int i=0; i<m; i++) {
//             for (int j=0; j<n; j++) {
//                 rows[i] += grid[i][j];
//                 cols[j] += grid[i][j];
//             }
//         }
        
//         for (int i=0; i<m; i++) {
//             for (int j=0; j<n; j++) {
//                 diff[i][j] = 2*rows[i] + 2*cols[j] - n - m;
//             }
//         }
        
//         return diff;
    }
}