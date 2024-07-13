class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        
        for(int i=0; i<n; i++){
            int min = nums[i], max = nums[i];
            for(int j=i; j<n; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                answer += max - min;
            }
        }
        
        return answer;
    }
}