class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if(nums.length == 2) return nums[1];
        int before = nums[0], cnt = 0;
        for(int i = nums.length-1 ;i >=  1 ; i--){
            if(nums[i-1] != nums[i]) {
                before = nums[i];
                if(++cnt == 3) return before;
            }
        }
        if(cnt == 1 ) return nums[nums.length-1];
        return nums[0];
    }
}