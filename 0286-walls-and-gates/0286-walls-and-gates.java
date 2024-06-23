class Solution {
    
    class Point {
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public void wallsAndGates(int[][] rooms) {
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[i].length; j++){
                if(rooms[i][j]== 0){
                    q.add(new Point(i, j));
                } 
            }
        }
        
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0; i<4; i++){
                int nx = p.x + dir[i][0];
                int ny = p.y + dir[i][1];
                if(nx >= 0 && nx < rooms.length && ny >=0 && ny < rooms[0].length && rooms[p.x][p.y]+1 <= rooms[nx][ny]){
                    rooms[nx][ny] = rooms[p.x][p.y]+1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }
    
    
}