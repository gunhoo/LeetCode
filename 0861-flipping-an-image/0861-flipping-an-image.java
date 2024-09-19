class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[] tmp = new int[image.length];
        for(int j=0; j<image.length; j++){
            tmp = Arrays.copyOf(image[j], image.length);
            for(int i=tmp.length-1; i>=0; i--){
                image[j][i] = tmp[image.length-1-i]==0?1:0;
            }
        }
        return image;
    }
}