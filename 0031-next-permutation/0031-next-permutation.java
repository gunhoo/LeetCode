class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i+1] > nums[i]){
                index = i;
                break;
            }
        }
        if(index == -1) {
            reverse(nums, 0);
            return;
        } 
        // if(index == nums.length-2){
        //     swap(nums, index, index+1);
        //     return;
        // }
        // System.out.println(index);
        int j=nums.length-1;
        while(nums[j] <= nums[index]) j--;
        swap(nums, index, j);
        reverse(nums, index+1);
    }

    private void reverse(int[] nums, int index){
        int l = index, r = nums.length-1;
        while(l<r){
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++; r--;
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}