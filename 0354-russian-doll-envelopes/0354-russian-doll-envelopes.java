class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)-> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] secondDim = new int[envelopes.length];
        for(int i=0; i<envelopes.length; i++){
            secondDim[i] = envelopes[i][1];
        }
        return binarySearch(secondDim);
    }

    private int binarySearch(int[] array){
        int[] dp = new int[array.length];
        int len = 0;
        for(int i=0; i<array.length; i++){
            int idx = Arrays.binarySearch(dp, 0, len, array[i]);
            if(idx < 0){
                idx = -(idx+1);
            }
            dp[idx] = array[i];
            if(len == idx) len += 1;
        }
        return len;
    }
}