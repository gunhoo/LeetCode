class Solution {
    public int countValidSelections(int[] nums) {
        int rightSum=0, leftSum=0;
        int answer = 0;

        for(int num : nums) rightSum += num;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                if(leftSum == rightSum){
                    answer += 2;
                } else if(Math.abs(rightSum-leftSum)==1){
                    answer += 1;
                }
            }
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return answer;
    }
}
// if the lefsum == rightsum -> 2
// if the leftsum - rightsum == 1 -> 1
// if the rightsum - leftsum == 1 -> 1