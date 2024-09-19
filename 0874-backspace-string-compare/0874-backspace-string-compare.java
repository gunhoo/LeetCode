class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> ts = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '#'){
                if(!ss.isEmpty()) ss.pop();
            } else {
                ss.add(s.charAt(i));
            }
        }
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) == '#'){
                if(!ts.isEmpty()) ts.pop();
            } else {
                ts.add(t.charAt(i));
            }
        }
        if(ss.size() != ts.size()) return false;
        while(!ss.isEmpty()){
            if(ss.pop() != ts.pop()) return false;
        }
        return true;
    }
}