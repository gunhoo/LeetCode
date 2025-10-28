class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxNum = 0, currIteration = 0;
        for(int num : nums){
            if(num == 1){
                maxNum = Math.max(maxNum, ++currIteration);
            } else {
                currIteration = 0;
            }
        }
        return maxNum;
    }
}