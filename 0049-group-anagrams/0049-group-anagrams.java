class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        int[][] map = new int[strs.length][26];
        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            for(int j=0; j<s.length(); j++){
                map[i][s.charAt(j)-'a']++;
            }
        }
        boolean[] visited = new boolean[strs.length];
        for(int i=0; i<strs.length; i++){
            if(visited[i]) continue;
            List<String> list = new LinkedList<>();
            list.add(strs[i]);
            for(int j=i+1; j<strs.length; j++){
                if(visited[j] == false && isEqualArray(map[i], map[j])){
                    visited[j] = true;
                    list.add(strs[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    
    private boolean isEqualArray(int[] a, int[] b){
        for(int i=0; i<a.length; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}