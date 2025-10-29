class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0]-b[0]);

        UnionFind uf = new UnionFind(n);
        int length = n;

        for(int[] log : logs){
            int time=log[0], a=log[1], b=log[2];
            if(uf.union(a, b)){
                length -= 1;
            }
            if(length == 1) return time;
        }
        return -1;        
    }


    class UnionFind{
        int[] group, rank;

        public UnionFind(int size){
            this.group = new int[size];
            this.rank = new int[size];
            for(int i=0; i<size; i++){
                this.group[i] = i;
                this.rank[i] = 0;
            }
        }

        public int find(int a){
            if(this.group[a] != a){
                this.group[a] = find(this.group[a]);
            }
            return this.group[a];
        }

        public boolean union(int a, int b){
            int groupA = find(a);
            int groupB = find(b);
            boolean isMerged = false;
            
            if(groupA == groupB) return isMerged;
            isMerged = true;

            if(this.rank[groupA] > this.rank[groupB]){
                this.group[groupB] = groupA;
            } else if(this.rank[groupA] < this.rank[groupB]){
                this.group[groupA] = groupB;
            } else {
                this.group[groupA] = groupB;
                this.rank[groupB] += 1;
            }
            return isMerged;
        }
    }
}