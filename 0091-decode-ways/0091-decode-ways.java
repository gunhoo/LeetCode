class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;

        int[] mem = new int[s.length()];
        return dfs(0, s, mem);
    }

    private int dfs(int p, String s, int[] mem){
        int n = s.length();
        if(p==n) return 1;
        if(s.charAt(p) == '0') return 0;
        if(mem[p]!=0) return mem[p];
        int res = dfs(p+1, s, mem);
        if(p<n-1 && (s.charAt(p)=='1' || s.charAt(p)=='2' && s.charAt(p+1)<'7')){
            res += dfs(p+2, s, mem);
        }
        return mem[p] = res;
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