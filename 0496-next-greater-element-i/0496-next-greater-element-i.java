class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            p: for(int j=0; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    for(int k=j+1; k<nums2.length; k++){
                        if(nums2[k] > nums2[j]){
                            answer[i] = nums2[k];
                            continue p;
                        }
                    }
                    answer[i] = -1;
                }
            }
        }
        return answer;
    }
}