class Solution {
    public boolean isPathCrossing(String path) {
        List<Point> set = new LinkedList<>();
        set.add(new Point(0,0));
        int[] idx = {0,0};
        for (int i=0; i<path.length(); i++){
            switch(path.charAt(i)){
                case 'N':
                    idx[1] += 1;
                    break;
                case 'W':
                    idx[0] -= 1;
                    break;
                case 'E':
                    idx[0] += 1;
                    break;
                case 'S':
                    idx[1] -= 1;
                    break;
            }
            
            for (Point p : set){
                if (p.x == idx[0] && p.y == idx[1]) {
                    return true;
                }
            }
            set.add(new Point(idx[0], idx[1]));
        }
        return false;
    }
    
    class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}