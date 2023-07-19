class Solution {
    public int reductionOperations(int[] nums) {
        int ans = 0;
        
        Arrays.sort(nums);
        int n = nums.length;
        for(int j = n-1 ; j > 0 ; --j){
            if(nums[j] != nums[j-1]){
                ans += n-j;
            }
        }
        return ans;
    }
}