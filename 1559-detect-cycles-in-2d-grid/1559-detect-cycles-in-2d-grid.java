class Solution {
    public static int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static int startX, startY;
    public boolean visited[][];
    
    public boolean containsCycle(char[][] grid) {
        
        for(int i = 0 ; i < grid.length-1; i++){
            for(int j =0 ;j < grid[i].length-1 ; j++){
                if(grid[i][j] != grid[i+1][j] || grid[i][j] != grid[i][j+1] ) continue;
                visited = new boolean[grid.length][grid[0].length];
                visited[i][j] = true;
                startX = i; startY = j;
                if(dfs(grid, 1, i, j)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] grid, int cnt, int x, int y){        
        for(int i = 0 ; i < 4; i++){
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if( 0 <= nx && 0 <= ny && nx < grid.length && ny < grid[0].length && 
               grid[nx][ny] == grid[startX][startY] ){
                if( nx == startX && ny == startY && visited[nx][ny] && cnt >= 4 ) return true;
                if(visited[nx][ny]) continue;
                visited[nx][ny]  = true;
                // System.out.println(nx+" "+ny);
                if(dfs(grid, cnt+1, nx, ny)) return true;
            }
        }
        
        return false;
    }
}