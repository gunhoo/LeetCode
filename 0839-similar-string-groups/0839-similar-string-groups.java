class Solution {
    public int numSimilarGroups(String[] strs) {
        boolean[] visited = new boolean[strs.length];
        int count = 0;

        for(int i=0; i<strs.length; i++){
            if(!visited[i]){
                count += 1;
                dfs(i, strs, visited);
            }
        }

        return count;
    }

    private void dfs(int i, String[] strs, boolean[] visited){
        visited[i] = true;
        for(int j=0; j<strs.length; j++){
            if(!visited[j] && isSameGroup(strs[i], strs[j])){
                dfs(j, strs, visited);
            }
        }
    }

    private boolean isSameGroup(String a, String b){
        int totalDiff = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) totalDiff++;
        }
        return totalDiff == 2 || totalDiff == 0;
    }
}