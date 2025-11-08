class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // find the first idx that stores previous planted place (started from the first plantable place)
        // iterate from firstIdx to the end, find the next plantable place until n becomes 0 while n -= 1 
        // 0 1 1
        // 1 0 0
        if(n==0) return true;
        int idx = -1;
        for(int i=0; i<flowerbed.length; i++){
            if(flowerbed[i] == 0) {
                idx = i;
                break;
            }
        }
        if(idx == -1) return false;
        for(int i=idx; i<flowerbed.length; i++){
            if(flowerbed[i]!=0)continue;
            if(i-1 < 0 || flowerbed[i-1] == 0){
                if(i+1>=flowerbed.length || flowerbed[i+1] == 0){
                    n -= 1;
                    flowerbed[i] = 1;
                    idx = i+1;
                    if(n==0) return true;
                }
            }
        }
        return false;
    }
}