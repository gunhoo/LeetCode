class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1, right=1;
        for(int p : piles) right = Math.max(p, right);
        
        while(left < right){
            int mid = (left+right)/2;
            int hourSpent = 0;
            
            for(int p : piles) hourSpent += Math.ceil((double) p / mid);
            
            if(hourSpent <= h) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}