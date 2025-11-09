class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int idx=0;
        Stack<Character> stack = new Stack<>();
        stack.add(chars[0]);
        for(int i=1; i<chars.length; i++){
            if(!stack.isEmpty() && stack.peek() == chars[i]) stack.add(chars[i]);
            else {
                int size = stack.size();
                if(size == 1){
                    chars[idx++] = stack.pop();
                } else {
                    chars[idx++] = stack.peek();
                    // size = 10
                    String len = String.valueOf(size);
                    for(int j=0; j<len.length(); j++){
                        chars[idx++] = len.charAt(j);
                    }
                    stack.clear();
                }
                stack.add(chars[i]);
            }
        }
        if(!stack.isEmpty()){
            chars[idx++] = stack.peek();
            int size = stack.size();
            String len = String.valueOf(size);
            if(size != 1) for(int j=0; j<len.length(); j++) chars[idx++] = len.charAt(j);
        }
        return idx;
    }
}