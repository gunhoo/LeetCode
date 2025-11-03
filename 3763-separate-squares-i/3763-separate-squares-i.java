class Solution {
    public double separateSquares(int[][] squares) {
        double minY = 0.0;
        double maxY = 0.0;

        for (int[] square : squares) {
            minY = Math.min(minY, square[1]);
            maxY = Math.max(maxY, square[1] + square[2]);
        }
        
        while(maxY-minY > (1e-5)){
            double midY = (minY+maxY) / 2;
            
            if(isUpperLarge(squares, midY)){
                minY = midY;
            } else {
                maxY = midY;
            }
        }
        return maxY;
    }

    private boolean isUpperLarge(int[][] squares, double midY){
        double upperTotal=0.0, belowTotal=0.0;
        for(int[] square : squares){
            int x=square[0], y=square[1], l=square[2];
            double total = 1.0 * l * l;
            if(midY <= y){
                upperTotal += total;
            } else if(midY >= y+l){
                belowTotal += total;
            } else {
                double upperHeight = (y+l)-midY;
                double belowHeight = midY-y;
                upperTotal += upperHeight * l;
                belowTotal += belowHeight * l;
            }
        }
        return (upperTotal - belowTotal) > 0.0;
    }
}