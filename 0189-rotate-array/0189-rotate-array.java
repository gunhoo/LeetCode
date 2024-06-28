class Solution {
    public void rotate(int[] nums, int k) {
        if(k == nums.length || nums.length == 1) return;
        while(k>nums.length) k -= nums.length;
        int[] tmp = new int[nums.length-k];
        for(int i=0; i<nums.length-k; i++){
            tmp[i] = nums[i];
        }
        for(int i=0; i<k; i++){
            nums[i] = nums[i+nums.length-k];
        }
        for(int i=k; i<nums.length; i++){
            nums[i] = tmp[i-k];
        }
    }
}