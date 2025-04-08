class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '0') continue;
                dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1])+1;
                maxArea = Math.max(maxArea, dp[i][j]);
            }
        }
        return maxArea*maxArea;
    }
}