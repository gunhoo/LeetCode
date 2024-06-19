class SparseVector {
    Map<Integer, Integer> map;
    int ans = 0;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0) map.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        vec.map.forEach((key, value)->{
           if(this.map.containsKey(key)) ans += this.map.get(key)*value; 
        });
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);