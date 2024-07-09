class Solution {
    public String removeStars(String s) {
        Deque<Character> q = new ArrayDeque<>();
        int cnt = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '*'){
                cnt++;
            } else {
                if(cnt > 0){
                    cnt -= 1;
                    continue;
                } else {
                    q.addFirst(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.pollFirst());
        }
        return sb.toString();
    }
}