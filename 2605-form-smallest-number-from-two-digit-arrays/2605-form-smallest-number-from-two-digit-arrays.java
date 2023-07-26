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
                    if(Integer.parseInt(a+""+b) < min) min = Integer.parseInt(a+""+b);
                    if(Integer.parseInt(b+""+a) < min) min = Integer.parseInt(b+""+a);
                }
            }
        }
        return min;
    }
}