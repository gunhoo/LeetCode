class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            if(nums[0] == 0) return 0;
            else return 1;
        }
        
        int prev = -1;
        Arrays.sort(nums);
        if(nums[0] == 0 ) n = -1;
        else n = 0;
        for(int i =0 ; i < nums.length; i++){
            if(prev != nums[i]){
                n++;
                prev = nums[i];
            }
        }
        return n;
    }
}