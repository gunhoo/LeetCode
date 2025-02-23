class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = -1;
        while(l<r){
            int cap = (r-l) * Math.min(height[l], height[r]);
            max = Math.max(max, cap);
            if(height[r] < height[l]) r--;
            else l++;
        }
        return max;
    }
}