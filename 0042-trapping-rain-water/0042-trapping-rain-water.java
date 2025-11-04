class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int l=0, r=height.length-1;
        int leftMax = height[l], rightMax=height[r];
        while(l<r){
            if(height[l] < height[r]){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                answer += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                answer += rightMax - height[r];
            }
        }
        return answer;
            
    }
}