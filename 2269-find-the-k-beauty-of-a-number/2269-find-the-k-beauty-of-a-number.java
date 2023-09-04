class Solution {
    public int divisorSubstrings(int num, int k) {
        String stringNum = ""+num;
        int ans = 0;
        for(int i = 0; i <= stringNum.length()-k ; i++){
            if(Integer.parseInt(stringNum.substring(i, i+k)) == 0 )continue;
            if(num % Integer.parseInt(stringNum.substring(i, i+k)) == 0) ans++;
        }
        return ans;
    }
}