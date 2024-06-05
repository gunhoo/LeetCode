class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
        int iIdx = 0;
        int jIdx = 0;
        while( iIdx < m && jIdx < n){
            if(nums1[iIdx] <= nums2[jIdx]){
                ans[iIdx+jIdx] = nums1[iIdx];
                iIdx++;
            } else {
                ans[iIdx+jIdx] = nums2[jIdx];
                jIdx++;
            }
        }
        while(iIdx < m){
            ans[jIdx+ iIdx] = nums1[iIdx++];
        }
        while(jIdx < n){
            ans[iIdx + jIdx] = nums2[jIdx++];
        }
        for(int i=0; i<m+n; i++){
            nums1[i] = ans[i];
        }
    }
}