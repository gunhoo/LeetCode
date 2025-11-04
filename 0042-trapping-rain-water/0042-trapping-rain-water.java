class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int size = height.length;
        for(int i=1; i< size-1; i++){
            int leftMax = 0, rightMax = 0;
            for(int j=i; j>=0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }
            for(int j=i; j<size; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            answer += Math.min(leftMax, rightMax) - height[i];
        }
        return answer;
            
    }
}