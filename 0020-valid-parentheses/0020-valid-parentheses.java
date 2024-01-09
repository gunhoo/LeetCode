class Solution {
    public boolean isValid(String s) {
        // stack
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()){
                if(isOpen(s.charAt(i))){
                    stack.push(s.charAt(i));
                } else {
                    return false;
                }
            } else {
                if(isOpen(s.charAt(i))) stack.push(s.charAt(i));
                else {
                    if(areMatch(stack.pop(), s.charAt(i))) continue;
                    return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
    
    private boolean isOpen(char c) {
        if(c == '(' || c == '{' || c == '[' ) return true;
        return false;
    }
    
    private boolean areMatch(char a, char b){
        if(a == '{' && b == '}') return true;
        if(a == '(' && b == ')') return true;
        if(a == '[' && b == ']') return true;
        return false;
    }
}