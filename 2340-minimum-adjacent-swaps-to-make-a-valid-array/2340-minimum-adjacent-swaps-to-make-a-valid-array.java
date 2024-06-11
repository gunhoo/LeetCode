class Solution {
    public int minimumSwaps(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx=0, maxIdx=0;
        for(int i=0; i<nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
                minIdx = i;
            }
            if(max <= nums[i]){
                max = nums[i];
                maxIdx = i;
            }
        }
        if(minIdx == 0) {
            if(maxIdx == nums.length-1){
                return 0;
            } else {
                return nums.length-1-maxIdx;
            }
        } else if(maxIdx == nums.length-1) {
            return minIdx;
        }
        if(minIdx > maxIdx) {
            System.out.printf("min: %d, max: %d", minIdx, maxIdx);
            return minIdx+nums.length-maxIdx-2;
        } else if (minIdx < maxIdx) {
            System.out.printf("min: %d, max: %d", minIdx, maxIdx);
            return minIdx + +nums.length-maxIdx-1;
        } else {
            return 0;
        }
    }
}