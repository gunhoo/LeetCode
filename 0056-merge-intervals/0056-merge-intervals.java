class Solution {
    public int[][] merge(int[][] intervals) {
        boolean[] visited = new boolean[20002];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int[] term : intervals){
            int start = term[0]*2;
            int end = term[1]*2;
            if(start < min ) min = start;
            if(end > max ) max = end;
            for(int i=start; i<end+1; i++){
                visited[i] = true;
            }
        }
        // min *= 2; max*= 2;
        List<int[]> list = new ArrayList<>();
        boolean idx = true;
        int from=min;
        for(int i=min ; i<max+2; i++){
            if(!idx && !visited[i]){// if not started and not in a range
                continue;
            } else if (idx && visited[i]){ // if started and in a range
                continue;
            } else if(idx && !visited[i]){ // if started and visit the end fo that range
                idx = false;
                list.add(new int[]{from/2, (i)/2});
            } else { // if not started and in a range
                idx = true;
                from = i;
            }
        }
        
        int[][] ans = new int[list.size()][2];
        for(int i=0; i<ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}