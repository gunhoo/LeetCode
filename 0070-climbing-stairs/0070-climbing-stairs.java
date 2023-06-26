class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2 || n == 3) return n;
        int[] answer = {1, 2, 3};
        
        for(int i = 0; i < n-3; i++){
            answer[0] = answer[1];
            answer[1] = answer[2];
            answer[2] = answer[0] + answer[1];
        }
        return answer[2];
        
    }
}