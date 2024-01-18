class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int l=0, r=0, u=0;
        for(int i=0; i<n; i++) {
            if(moves.charAt(i) == 'L') l++;
            else if(moves.charAt(i) == 'R') r++;
            else u++;
        }
        return Math.max(l, r)+ u - Math.min(l, r);
    }
}