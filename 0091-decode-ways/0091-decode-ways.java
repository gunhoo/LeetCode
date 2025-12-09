class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i+1];
                if(i<n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2'&& s.charAt(i+1) < '7')){
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }
}

// nums[1] => if the first two letters are 11, 12, ... 19, 21, 22, 23, 24, 25, 26 => 2
// 2222
// 1 2 

// B
// BB V
// BBB, B+V V+B
// BBBB BVB VBB VV BBV

// 202
// TB

// 282
// BHB

// 888
// HHH