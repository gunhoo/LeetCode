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
        for(int next=cur+1; next<jobs.length; next++){
            if(jobs[next][0] >= jobs[cur][1]) return next;
        }
        return -1;
    }
    
}