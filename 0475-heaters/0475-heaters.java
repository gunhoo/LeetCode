class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses); 
        Arrays.sort(heaters);
        int i = 0, ans = 0;
        for(int house : houses){
            while(i<heaters.length-1 && heaters[i]+heaters[i+1]<=2*house) i++;
            ans = Math.max(ans, Math.abs(heaters[i]-house));
        }
        return ans;
    }
}