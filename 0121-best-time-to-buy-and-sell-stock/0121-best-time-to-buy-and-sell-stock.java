class Solution {
    public int maxProfit(int[] prices) {
        // 7 3 4 6 0 5
        int min=prices[0], max=prices[0];
        int candidate = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<prices[i-1]){
                candidate = Math.max(candidate, prices[i]-min);
                min = Math.min(min, prices[i]);
            } else {
                candidate = Math.max(candidate, prices[i]-min);
            }
        }
        return candidate;
    }
}