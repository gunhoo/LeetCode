class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1 || nums[0] < nums[nums.length-1]) return nums[0];

        int l = 0, r = nums.length-1;

        while(l<=r){
            int m = (l+r)/2;
            if(nums[m] > nums[m+1]){
                return nums[m+1];
            }
            if(nums[m-1]>nums[m]){
                return nums[m];
            }

            if(nums[m] > nums[0]){
                l = m+1;
            } else {
                r = m-1;
            }
        }
        
        return -1;
    }
}