class Solution {
    public int trap(int[] height) {
        int answer = 0;
        for(int i=0; i<height.length; i++){
            int leftMax=0, rightMax=0;
            for(int j=i; j>=0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j=i; j<height.length; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            answer += Math.min(rightMax, leftMax) - height[i];
        }
        return answer;
    }
}