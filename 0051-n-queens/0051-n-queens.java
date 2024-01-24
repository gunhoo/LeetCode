class Solution {
    List<List<String>> answer = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        for(int i=0; i<n; i++) {
            char[][] map = new char[n][n];
            
            for(int j=0; j<n; j++){
                if(j==i) map[0][j] = 'Q';
            }
            for(int j=1;j<n; j++) {
                map[j][i] = '.';
                if(j+i<n) map[j][j+i] = '.';
                if(i-j>=0) map[j][i-j] = '.';
            }
            dfs(i, 0, map, n);
            // System.out.println("i: "+i+" & length: "+answer.size());
        }
        return answer;
    }
    
    private void dfs(int a, int b, char[][] map, int n) {
        if(b==n-1){
            for(int i=0; i<n; i++){
                if(map[b][i]!='.'){
                    // found the n-queens puzzle!
                    map[b][i] = 'Q';
                    makingMapToArray(map);
                    return;
                }
            }
            return;
        }
        
        
        for(int i=0; i<n; i++) {
            if(map[b+1][i] != '.' && map[b+1][i] != 'Q'){
                char[][] tmp = new char[n][n];
                for(int j=0; j<n;j++) tmp[j] = Arrays.copyOf(map[j], n);
                tmp[b+1][i] = 'Q';
                for(int j=b+2;j<n; j++) {
                    tmp[j][i] = '.';
                    if(i+j-b-1 < n ) tmp[j][i+j-b-1] = '.';
                    if(i-j+b+1 >= 0) tmp[j][i-j+b+1] = '.';
                }
                // printMap(tmp);
                dfs(i, b+1, tmp, n);
                map[b+1][i] = '.';
            }
        }
    }
    
    private void makingMapToArray(char[][] map){
        List<String> listedMap = new ArrayList<>();
        for(int i=0; i<map.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<map.length; j++){
                if(map[i][j] == 'Q' || map[i][j] == '.')
                sb.append(String.valueOf(map[i][j]));
                else sb.append('.');
            }
            listedMap.add(sb.toString());
        }
        answer.add(listedMap);
    }    
}