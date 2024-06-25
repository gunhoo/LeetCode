class Solution {
    int[][] directions = {{0,1}, {1,0}, {-1,0},{0,-1}};
    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length, n = grid2[0].length, ans=0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid2[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i,j));
                    List<Point> islands = new ArrayList();
                    while(!q.isEmpty()){
                        Point p = q.poll();
                        islands.add(new Point(p.x, p.y));
                        for(int k=0; k<4; k++){
                            int nx = p.x+directions[k][0];
                            int ny = p.y+directions[k][1];
                            if(0<=nx && nx<m && ny>=0 && ny<n && grid2[nx][ny]==1&& !visited[nx][ny]){
                                visited[nx][ny] = true;
                                q.add(new Point(nx,ny));
                            }
                        }
                    }
                    if(checkSubIslands(islands, grid1)) ans+=1;
                }
            }
        }
        return ans;
    }
    
    private boolean checkSubIslands(List<Point> list, int[][] grid1){
        for(int i=0; i<list.size(); i++){
            Point p = list.get(i);
            if(grid1[p.x][p.y] != 1 ) return false;
        }
        return true;
    }
    
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x; this.y = y;
        }
    }
}