class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || x != 0 && x % 10 == 0) return false;
        else if(x == 0) return true;
        
        int idx = x;
        int reserved = 0;
        
        while(idx != 0){
            reserved = (reserved * 10) + (idx % 10);
            idx /= 10;
        }
        if(reserved == x) return true;
        return false;
    }
}