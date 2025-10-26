class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int ans = 0;
        int lastIndex = 0;
        Map<Integer, Integer> numCount = new HashMap<>();

        for(int i=0; i<nums.length; ++i){
            if(nums[i] != nums[lastIndex]) {
                numCount.put(nums[lastIndex], i-lastIndex);
                ans = Math.max(ans, i-lastIndex);
                lastIndex = i;
            }
        }

        numCount.put(nums[lastIndex], nums.length-lastIndex);
        ans = Math.max(ans, nums.length-lastIndex);

        for(int i=nums[0]; i<=nums[nums.length-1]; i++){
            int l = leftBound(nums, i-k);
            int r = rightBound(nums, i+k);
            int tmp;
            if(numCount.containsKey(i)){
                tmp = Math.min(r-l+1, numCount.get(i)+numOperations);
            } else {
                tmp = Math.min(r-l+1, numOperations);
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    private int leftBound(int[] nums, int value){
        int l = 0, r = nums.length-1;
        while(l<r){
            int m = (l+r)/2;
            if(nums[m] < value){
                l = m+1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int rightBound(int[] nums, int value){
        int l = 0, r = nums.length-1;
        while(l<r){
            int m = (l+r+1)/2;
            if(nums[m] > value) {
                r = m-1;
            } else {
                l = m;
            }
        }
        return l;
    }
}