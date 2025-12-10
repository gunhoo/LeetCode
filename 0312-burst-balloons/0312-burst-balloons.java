class Solution {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = newNums[nums.length+1] = 1;
        for(int i=1; i<nums.length+1; i++){
            newNums[i] = nums[i-1];
        }
        int[][] mem = new int[nums.length+2][nums.length+2];

        return getMaxCoins(newNums, mem, 0, nums.length+1);
    }

    private int getMaxCoins(int[] nums, int[][] mem, int left, int right){
        if(left+1 >= right) return 0;
        if(mem[left][right] > 0) return mem[left][right];
        int maxCoins = 0;
        for(int i=left+1; i<right; i++){
            maxCoins = Math.max(maxCoins, nums[left]*nums[i]*nums[right] + getMaxCoins(nums, mem, left, i) + getMaxCoins(nums, mem, i, right));
        }
        mem[left][right] = maxCoins;
        return maxCoins;
    }
}