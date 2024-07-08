class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        Arrays.sort(nums);
        List<Long> ans = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        
        for(int num : queries){
            int idx = Arrays.binarySearch(nums, num);
            if(idx < 0) idx = -idx-1;
            ans.add(1L * num * (2*idx-n)+prefix[n] -2*prefix[idx]);
        }
        return ans;
    }
}