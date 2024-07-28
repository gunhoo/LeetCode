class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            String str = tokens[i];
            if(str.matches("-?\\d+")){
                stack.push(Integer.parseInt(str));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int cal = cal(a, b, str);
                stack.push(cal);
            }
        }
        return stack.pop();
    }
    
    private int cal(int a, int b, String operation){
        char c = operation.charAt(0);
        switch(c){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            default:
                return a/b;
        }
    }
}