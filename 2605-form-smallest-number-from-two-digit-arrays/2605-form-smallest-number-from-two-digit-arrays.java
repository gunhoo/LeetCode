class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0 ; i < nums1.length ; i++){
            int a = nums1[i]; int b = Integer.MAX_VALUE;
            for(int j =0 ; j < nums2.length; j++){
                b = nums2[j];
                if(a == b){
                    if(min > a) min = a;
                }else{
                    if(a*10+b < min) min = a*10+b;
                    if(b*10+a < min) min = b*10+a;
                }
            }
            if(min / 10 == 0) break;
        }
        return min;
    }
}