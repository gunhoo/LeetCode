class Solution {
    public int countPaths(int n, int[][] roads) {
        int[] pathCounts = new int[n];
        long[] dist = new long[n];
        List<List<int[]>> map = new ArrayList<>();

        for(int i=0; i<n; i++){
            map.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
        }

        for(int[] r : roads){
            map.get(r[0]).add(new int[]{r[1], r[2]});
            map.get(r[1]).add(new int[]{r[0], r[2]});   
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a->a[1])); // node, distance
        pq.add(new long[]{0,0});
        dist[0] = 0;
        pathCounts[0] = 1;

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int)curr[0];
            long d = curr[1];
            if(d > dist[node]) continue;
            
            List<int[]> neighbors = map.get(node);

            for(int[] neighbor : neighbors){
                int next  = neighbor[0];
                int dis = neighbor[1];
                if(dist[next] > dis + d){
                    dist[next] = dis + d;
                    pathCounts[next] = pathCounts[node];
                    pq.offer(new long[]{next, dist[next]});
                } else if (dist[next] == dis + d){
                    pathCounts[next] = (pathCounts[next] + pathCounts[node])%1000000007;
                }
            }
        }
        return pathCounts[n-1];
    }
}