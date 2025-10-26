class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for(int i=0; i<points.length; i++){
            int[] a = points[i]; 
            for(int j=i+1; j<points.length; j++){
                int[] b = points[j];
                for(int k=j+1; k<points.length; k++){
                    int[] c = points[k];
                    double area = Math.abs(a[0]*b[1]+b[0]*c[1]+c[0]*a[1]-a[1]*b[0]-b[1]*c[0]-c[1]*a[0]) * 0.5;
                    ans = Math.max(ans, area);
                }
            }
        }
        return ans;
    }
}