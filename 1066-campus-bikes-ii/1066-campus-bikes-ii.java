class Solution {
    private int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] used = new boolean[bikes.length];
        dfs(workers, 0, 0, bikes, used);
        return min;
    }
    
    private void dfs (int[][] workers, int indexOfWorkers, int sum, int[][] bikes, boolean[] used) {
        if(workers.length == indexOfWorkers) {
            min = Math.min(min, sum);
            return;
        }
        if( sum >= min) return;
        
        for(int i=0; i<bikes.length; i++){
            if(!used[i]){
                used[i] = true;
                dfs(workers, indexOfWorkers+1, sum+getDistance(workers[indexOfWorkers], bikes[i]), bikes, used );
                used[i] = false;
            }
        }
    }
    
    private int getDistance(int[] workers, int[] bikes){
        return Math.abs(workers[0]-bikes[0])+Math.abs(workers[1]-bikes[1]);
    }
}