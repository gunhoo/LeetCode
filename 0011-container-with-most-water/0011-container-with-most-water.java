class Solution {
    public int maxArea(int[] height) {
        int left = 0, answer = 0, right = height.length - 1;
        
        if(height.length == 1 ) return 1;
        
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            answer = Math.max(answer, h*w);
            if( height[left] < height[right] ){
                left++;
            } else if (height[left] > height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }
        return answer;
    }
}