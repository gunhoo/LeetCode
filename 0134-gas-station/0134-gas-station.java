class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0, total = 0, ans = 0;
        for(int i=0; i<gas.length; i++){
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            
            if(cur < 0){
                ans = i+1;
                cur = 0;
            }
        }
        return total >= 0 ? ans : -1;
    }
}