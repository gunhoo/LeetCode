class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIdx=0, nIdx=0;
        int[] newNums = new int[m+n];
        while(mIdx<m && nIdx<n){
            if(nums1[mIdx] < nums2[nIdx]){
                newNums[mIdx+nIdx] = nums1[mIdx++];
            } else {
                newNums[mIdx+nIdx] = nums2[nIdx++];
            }
        }
        while(mIdx<m){
            newNums[mIdx+nIdx] = nums1[mIdx++];
        }
        while(nIdx<n){
            newNums[mIdx+nIdx] = nums2[nIdx++];
        }
        for(int i=0; i<m+n; i++){
            nums1[i] = newNums[i];
        }
    }
}