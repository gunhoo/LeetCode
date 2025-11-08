class Solution {
    public int pivotIndex(int[] nums) {
        // sliding window 
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum == 0 && nums.length % 2 != 0) return 0;
        if(nums.length == 1) return 0;
        int leftSum=0, rightSum=sum-nums[0];
        int l=0, r=nums.length-1;
        if (leftSum == rightSum) return 0;
        for(int i=1; i<nums.length; i++){
            leftSum += nums[i-1];
            rightSum -= nums[i];
            if(leftSum == rightSum) return i;
        }
        return -1;
    }
}