class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for(int i=0; i < prices.length; i++){
            int cur = prices[i];
            if(cur < min){
                min = cur;
            }else{
                max = Math.max(max, cur-min);
            }
        }
        return max;
    }
}