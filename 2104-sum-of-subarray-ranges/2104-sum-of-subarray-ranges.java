class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[][] min = new int[n][n];
        int[][] max = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    min[i][j] = nums[i];
                    max[i][j] = nums[i];
                } else if(i<j){
                    min[i][j] = 2000000003;
                    max[i][j] = -2000000003;
                } else {
                    min[i][j] = Integer.MAX_VALUE;
                    max[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                min[i][j] = Math.min(min[i][j-1], nums[j]);
                max[i][j] = Math.max(max[i][j-1], nums[j]);
            }
        }
        
        long answer = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(min[i][j] == 2000000003 || max[i][j] == -2000000003) continue;
                answer += (max[i][j] - min[i][j]);
            }
        }
        
        return answer;
    }
}

// i부터 j까지 max/min 은 Max
// MAX(i,j) = MAX(MAX(i,j-1), j)
// MIN(i,j) = MIN(MIN(i, j-1), j)
    
    
//     2차원 DP 만들어야겠네
    
    