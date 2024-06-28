class Solution {
    public int removeDuplicates(int[] nums) {
        int ans = 0, before = nums[0];
        for(int i=1; i<nums.length; i++){
            if(before != nums[i]){
                nums[++ans] = nums[i];
                before = nums[i];
            }
        }
        return ans+1;
    }
}