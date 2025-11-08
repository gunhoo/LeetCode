class Solution {
    public int equalPairs(int[][] grid) {
        int totalPairs = 0;
        String[] row = new String[grid.length];
        String[] col = new String[grid.length];

        for(int i=0; i<grid.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid[i].length; j++){
                sb.append(grid[i][j]+" ");
            }
            row[i] = sb.toString();
        }

        for(int i=0; i<grid[0].length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<grid.length; j++){
                sb.append(grid[j][i]+" ");
            }
            col[i] = sb.toString();
        }
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(row[j].equals(col[i])) totalPairs++;
            }
        }
        return totalPairs;
    }
}