class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        if(height.length == 1) return 1;
        for(int i = 0 ; i < height.length-1 ; i++){
            if(10000 * (height.length - i) <= answer ) break; 
            for(int j = i+1 ; j < height.length ; j++){
                answer = Math.max(answer, (j-i)*Math.min(height[i], height[j]));
            }
        }
        return answer;
    }
}