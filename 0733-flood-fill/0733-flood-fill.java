class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = image.length, n = image[0].length;
        boolean visited[][] = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});

        visited[sr][sc] = true;
        int origin = image[sr][sc];
        image[sr][sc]=color;

        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int i=0; i<4; i++){
                int nx = pos[0] + direction[i][0];
                int ny = pos[1] + direction[i][1];
                if(0<=nx && nx<m && ny>=0 && ny<n && !visited[nx][ny] && image[nx][ny]==origin && image[nx][ny]!=color){
                    image[nx][ny] = color;
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return image;
    }
}