class Solution {
    public void solve(char[][] board) {
        if(board.length == 1) return;
        int m = board.length, n = board[0].length;
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean[][] visited = new boolean[m][n];
        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            if(board[i][0] == 'O'){
                q.add(new Point(i, 0));
            }
            if(board[i][n-1] == 'O'){
                q.add(new Point(i, n-1));
            }
        }
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O'){
                q.add(new Point(0, i));
            }
            if(board[m-1][i] == 'O'){
                q.add(new Point(m-1, i));
            }
        }
        while(!q.isEmpty()){
            Point p = q.poll();
            visited[p.x][p.y] = true;
            for(int i=0; i<4; i++){
                int nx = p.x + directions[i][0];
                int ny = p.y + directions[i][1];
                if(nx>=0 && ny>=0 && nx<m && ny<n && board[nx][ny]=='O' && visited[nx][ny] == false){
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}