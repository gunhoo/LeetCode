class Solution {
    public int totalMoney(int n) {
        // curr Monday = prev Monday + 1
        // curr week = 3*(currMonday+1 + currentMonday+6)
        // curr week = 6*currMonday + 21
        int week = n/7;
        int sum = 0;
        int monday = 0;
        for(int i=1; i<=week; i++){
            int thisMonday = monday + 1;
            sum += thisMonday;
            monday = thisMonday;
            sum += 6*thisMonday + 21;
        }
        monday += 1;
        for(int i=0; i<n%7; i++){
            sum = sum + monday + i;
        }
        return sum;
    }
}