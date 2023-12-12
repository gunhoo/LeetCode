class Solution {
    public int maxProduct(int[] nums) {
        int biggest = 0, secondBiggest = 0;
        for(int i = 0; i < nums.length; i++){
            if (nums[i] > biggest) {
                secondBiggest = biggest;
                biggest = nums[i];
            } else {
               secondBiggest = Math.max(secondBiggest, nums[i]);
            }
        }
        return (biggest-1)*(secondBiggest-1);
    }
}