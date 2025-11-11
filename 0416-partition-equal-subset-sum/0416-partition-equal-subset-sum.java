class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        dp[0][0] = true;
        for(int i=1; i<=nums.length; i++){
            int curr = nums[i-1];
            for(int j=0; j<=sum; j++){
                if(j < curr){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-curr];
                }
            }
        }
        return dp[nums.length][sum];
    }
}