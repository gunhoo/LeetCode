class Solution {
    
    class CharPoint{
        char c;
        int i;
        public CharPoint(char c, int i){
            this.c = c;
            this.i = i;
        }
    }
    
    public String minRemoveToMakeValid(String s) {
        Queue<CharPoint> q = new LinkedList<>();
        String ans = "";
        int cnt = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                q.add(new CharPoint(c, ans.length()+q.size()));
            } else if(c == ')'){
                if(q.isEmpty()){
                    // do nothing
                } else {
                    CharPoint cp = q.poll();
                    ans = ans.substring(0, cp.i) + cp.c + ans.substring(cp.i)+c;
                }
            } else {
                ans += c;
            }
        }
        return ans;
    }
}