class Solution {
    class UnionFind{
        int count;
        int[] parent, rank;

        public UnionFind(char[][] grid){
            count = 0;
            int m = grid.length, n = grid[0].length;
            this.parent = new int[m*n];
            this.rank = new int[m*n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(grid[i][j] != '0'){
                        parent[i*n+j] = i*n+j;
                        count++;
                    }
                    rank[i*n+j]=0;
                }
            }
        }

        public int find(int x){
            if(parent[x]!=x) parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                } else if(rank[rootX] < rank[rootY]){
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != '0'){
                    grid[i][j] = '0';
                    if(i-1>=0 && grid[i-1][j]!='0'){
                        uf.union(i*n+j, (i-i)*n+j);
                    }
                    if(i+1<m && grid[i+1][j]!='0'){
                        uf.union(i*n+j, (i+1)*n+j);
                    }
                    if(j-1>=0 && grid[i][j-1]!='0'){
                        uf.union(i*n+j, i*n+j-1);
                    }
                    if(j+1<n && grid[i][j+1]!='0'){
                        uf.union(i*n+j, i*n+j+1);
                    }
                }
            }
        }
        return uf.count;
    }
}