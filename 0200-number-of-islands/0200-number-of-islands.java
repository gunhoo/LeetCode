class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int initX= 0, initY = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int answer = 0;
        
        for(int i = 0 ; i < m ; i++) {
           for(int j=0; j<n; j++) {
               if(grid[i][j] == '1') {
                   answer++;
                   Queue<Point> q = new LinkedList<>();
                   q.add(new Point(i, j));
                   while(!q.isEmpty()){
                       Point p = q.poll();
                       for(int ii = 0; ii < 4 ; ii++){
                           int nx = p.x + directions[ii][0];
                           int ny = p.y + directions[ii][1];
                           if(0<=nx && 0<= ny && nx < m && ny < n && grid[nx][ny] == '1'){
                               q.add(new Point(nx, ny));
                               grid[nx][ny] = '0';
                           }
                        }
                    }
                   
               }
           }
        }
        return answer;
    }
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}