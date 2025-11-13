class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int length = nums.size();
        int[] arr = new int[length];
        for(int i=0; i<length; i++) arr[i] = nums.get(i);

        int l = 0;
        int r = l+k;

        while(r+k <= length){
            if(isIncreasing(arr, l, r) && isIncreasing(arr, r, r+k)) return true;
            l++; r++;
        }
        return false;
    }

    private boolean isIncreasing(int[] nums, int l, int r){
        int prev = Integer.MIN_VALUE;
        for(int i=l; i<r; i++){
            if(prev >= nums[i]) return false;
            prev = nums[i];
        }
        return true;
    }
}
// 1. Brute force
// { k1 } { k2 } check each subarrays are strictly increasing or not
// if found, return true
// else:
// move k1 and k2 the next index
// O(NK) O(N*(N/2)) => O(N^2)