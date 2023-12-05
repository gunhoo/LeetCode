class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int max = -1;
        for(int i = 0 ; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] < k){
                    max = Math.max(max, nums[i]+nums[j]);
                }
            }
        }
        return max;
    }
}