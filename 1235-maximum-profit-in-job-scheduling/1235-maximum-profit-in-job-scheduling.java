class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for(int i=0; i<n; i++) jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (a,b)-> a[0]-b[0]);
        int[] dp = new int[n];
        dp[n-1] = jobs[n-1][2];
        
        for(int i=n-2; i>=0; i--){
            int next = findNext(i, jobs);
            dp[i] = Math.max(dp[i+1], jobs[i][2]+ (next == -1 ? 0 : dp[next]));
        }
        
        return dp[0];
    }
    
    private int findNext(int cur, int[][] jobs){
        int l = cur + 1;
        int r = jobs.length-1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(jobs[m][0] >= jobs[cur][1]){
                if(jobs[m-1][0] >= jobs[cur][1]) r = m-1;
                else return m;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
    
}