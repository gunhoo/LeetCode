class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> map = new ArrayList<>();
        for(int i=0; i<n; i++){
            map.add(new ArrayList<>());
        }
        for(int[] r : roads){
            map.get(r[0]).add(new int[]{r[1], r[2]});
            map.get(r[1]).add(new int[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] paths = new int[n];
        paths[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int)curr[0];
            long dis = curr[1];
            if(dis > dist[node]) continue;
            for(int[] neighbor : map.get(node)){
                int nextNode = neighbor[0];
                int time = neighbor[1];

                if(dist[node] + time < dist[nextNode]){
                    dist[nextNode] = dist[node] + time;
                    paths[nextNode] = paths[node];
                    pq.offer(new long[]{nextNode, dist[nextNode]});
                } else if (dist[node] + time == dist[nextNode]){
                    paths[nextNode] = (paths[nextNode]+paths[node])%1000000007;
                }
            }
        }
        return paths[n-1];
    }
}