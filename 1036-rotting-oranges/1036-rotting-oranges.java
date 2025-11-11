class Solution {
    public int orangesRotting(int[][] grid) {
        // map[][] visited that stores the cumulative path
        // Queue<int[]> that stores rotten orange 
        // while q is not empty -> execute bfs
        // if the neighbor is not visited and not empty(greater than 0) -> visited[i] = true & add it to the q
        // check all points are visited
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = grid.length, n = grid[0].length;
        int[][] map = new int[m][n]; 
        for(int i=0; i<m; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i, j});
                    map[i][j] = 0;
                } else if(grid[i][j] == 0){
                    map[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] rotten = q.poll();
            for(int i=0; i<4; i++){
                if(rotten[0]+direction[i][0] < 0 || rotten[0]+direction[i][0] >= m || rotten[1]+direction[i][1] < 0 || rotten[1]+direction[i][1] >= n) continue;
                if(map[rotten[0]+direction[i][0]][rotten[1]+direction[i][1]] == Integer.MAX_VALUE){
                    map[rotten[0]+direction[i][0]][rotten[1]+direction[i][1]] = map[rotten[0]][rotten[1]]+1;
                    q.add(new int[]{rotten[0]+direction[i][0], rotten[1]+direction[i][1]});
                }

            }
        }

        return maxValue(map);
    }

    private int maxValue(int[][] map){
        int max = 0;
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                max = Math.max(max, map[i][j]);
            }
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}