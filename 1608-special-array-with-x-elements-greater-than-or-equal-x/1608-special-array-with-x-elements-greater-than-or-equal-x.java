class Solution {
    public int specialArray(int[] nums) {
        int size = nums.length;
        // Arrays.sort(nums);
        // for( int x = 1 ; x <= size; x++){
        //     for(int i=0; i< size; i++){
        //         if(nums[i] >= x){
        //             if(size-i == x) return x;
        //             else break;
        //         }
        //     }
        // }
        // return -1;
        
        // for(int x = 1; x <= size; x++){
        //     int tmp = 0;
        //     for (int i = 0 ; i < size; i++) {
        //         if(nums[i] >= x) tmp++;
        //     }
        //     if(x == tmp) return tmp;
        // }
        // return -1;
        
        int[] count = new int[size+1];
        for (int i = 0; i < size; i++) {
            if(nums[i] >= size) count[size]++;
            else count[nums[i]]++;
        }
        
        int sum = 0;
        for (int i = size ; i > 0 ; i--) {
            sum += count[i];
            if(sum == i) return i;
        }
        return -1;
    }
}