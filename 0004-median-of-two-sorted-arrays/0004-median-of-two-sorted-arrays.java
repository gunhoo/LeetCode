class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        double answer = 0.0;
        
        int i=0, j=0;

        while(i<m && j<n){
            if((m+n)%2==0 && (i+j) == (m+n)/2 -1){
                if(nums1[i] < nums2[j]){
                    answer += nums1[i];
                } else {
                    answer += nums2[j];
                }
            } else if ((i+j) == (m+n)/2){
                if(nums1[i] < nums2[j]){
                    answer += nums1[i];
                } else {
                    answer += nums2[j];
                }
            }
            if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        while(i<m){ 
            if((m+n)%2 == 0 && (i+j) == (m+n)/2 -1){
                answer += nums1[i];
            } else if((i+j) == (m+n)/2){
                answer += nums1[i];
            }
            i++;
        }
        while(j<n){ 
            if((m+n)%2 == 0 && (i+j) == (m+n)/2 -1){
                answer += nums2[j];
            } else if((i+j) == (m+n)/2){
                answer += nums2[j];
            }
            j++;
        }
        return (m+n)%2 == 0 ? answer / 2.0 : answer;
    }
}