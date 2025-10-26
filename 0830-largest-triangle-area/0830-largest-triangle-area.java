class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                for(int k=j+1; k<points.length; k++){
                    double a = calculateLength(points[i], points[j]);
                    double b = calculateLength(points[j], points[k]);
                    double c = calculateLength(points[i], points[k]);
                    if(isValidTriangle(a,b,c)){
                        double s = (a+b+c)/2;
                        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
                        ans = Math.max(area, ans);
                    }
                }
            }
        }
        return ans;
    }

    private double calculateLength(int[] a, int[] b){
        return Math.sqrt((b[0]-a[0])*(b[0]-a[0]) + (b[1]-a[1])*(b[1]-a[1]));
    }

    private boolean isValidTriangle(double a, double b, double c){
        return a+b>c && b+c>a && c+a>b;
    }
}