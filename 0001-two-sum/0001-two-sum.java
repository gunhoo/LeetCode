class Solution {
    public int[] twoSum(int[] nums, int target) {
        int answer[] = new int[2], a = 0, b = 0;
        out: for(int i = 0; i < nums.length-1; i++){
            int tmpA = nums[i], tmpB;
            for(int j = i+1; j < nums.length; j++){
                tmpB = nums[j];
                if(tmpA+tmpB == target) {
                    a = i; b = j;
                    break out;
                }
            }
        }
        answer[0] = a; answer[1] = b;
        return answer;
    }
}