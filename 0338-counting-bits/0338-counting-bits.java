class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        if(n==0) return ans;
        ans[1] = 1;
        for(int i=2; i<=n; i++){
            if(i%2 == 0) ans[i] = ans[(i)/2];
            else ans[i] = ans[i-1]+1;
        }
        return ans;
    }
}

// 0 0
// 1 1 
// 2 10
// 3 11
// 4 100
// 5 101
// 6 110
// 7 111
