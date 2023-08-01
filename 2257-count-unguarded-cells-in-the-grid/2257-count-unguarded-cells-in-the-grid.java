class Solution {
    private static int map[][], ans = 0;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        map = new int[m][n]; // guard : 1, wall : -1, green : 0, red :2
        ans = n*m - walls.length - guards.length;
        for(int i = 0; i < walls.length; i++){
            map[walls[i][0]][walls[i][1]] = -1;
        }
        
        for(int i = 0; i < guards.length; i++){
            map[guards[i][0]][guards[i][1]] = 1;
        }
        for(int i = 0; i < guards.length; i++){
            go(guards[i][0], guards[i][1], n, m);
        }
        print(m,n);
        return ans;
    }
    
    private void go(int x, int y, int n, int m){
        if(x >= 1){
            for(int i = x-1; i >= 0; i--){
                if(map[i][y] == 0) {
                    map[i][y] = 2;
                    ans--;
                }
                else if(map[i][y] == 2) continue;
                else break;
            }
        }
        if(x+1 < m){
            for(int i = x+1; i < m ; i++){
                if(map[i][y] == 0){
                    map[i][y] = 2;
                    ans--;
                }
                else if(map[i][y] == 2) continue;
                else break; 
            }
        }
        if( y >= 1){
            for(int i = y-1; i >= 0 ; i--){
                if(map[x][i] == 0){
                    map[x][i] = 2;
                    ans--;
                }
                else if(map[x][i] == 2) continue;
                else break;
            }
        }
        if( y+1 < n){
            for(int i = y+1; i < n ; i++){
                if(map[x][i] == 0){
                    map[x][i] = 2;
                    ans--;
                }
                else if(map[x][i] == 2) continue;
                else break;
            }
        }
    }
    private void print(int m, int n){
        for(int i = 0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}