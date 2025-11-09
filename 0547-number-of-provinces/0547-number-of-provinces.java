class Solution {
    public int findCircleNum(int[][] isConnected) {
        int total = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            total++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int point = q.poll();
                for(int j=0; j<isConnected.length; j++){
                    if(isConnected[point][j] == 0 || visited[j]) continue;
                    visited[j] = true;
                    q.add(j);
                }
            }
        }
        return total;
    }
}