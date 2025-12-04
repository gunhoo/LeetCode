class Solution {
    public int countBattleships(char[][] board) {
        int totalBattleships = 0;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    totalBattleships += 1;
                    // BFS
                    Queue<Battleship> q = new LinkedList<>();
                    q.add(new Battleship(i, j));
                    while(!q.isEmpty()){
                        Battleship ship = q.poll();
                        int x = ship.x, y = ship.y;
                        for(int k=0; k<4; k++){
                            int nx = x + directions[k][0];
                            int ny = y + directions[k][1];
                            if(nx>=0 && nx<m && ny>=0 && ny<n && board[nx][ny]=='X' && !visited[nx][ny]){
                                visited[nx][ny] = true;
                                q.add(new Battleship(nx, ny));
                            }
                        }
                    }

                }
            }
        }

        
        return totalBattleships;
    }

    class Battleship{
        int x, y;

        public Battleship(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}