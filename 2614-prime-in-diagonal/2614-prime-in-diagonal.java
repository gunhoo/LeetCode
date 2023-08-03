class Solution {
    public int diagonalPrime(int[][] nums) {
        int max = 0;
        for(int i=0 ; i< nums.length ; i++ ){
            if(nums[i][i] > max && checkPrime(nums[i][i])) max = nums[i][i];
            if(nums[nums[i].length-1-i][i] > max && checkPrime(nums[nums[i].length-1-i][i])) max = nums[nums[i].length-1-i][i];
        }
        return max;
    }
    
    private boolean checkPrime(int num){
        if(num == 2) return true;
        else if(num % 2 == 0 || num == 1) return false;
        else{
            for(int i = 3; i < num ; i+=2){
                if( num % i == 0) return false;
            }   
        }
        return true;
    }
    
}