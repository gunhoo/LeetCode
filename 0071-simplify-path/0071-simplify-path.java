class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] p = path.split("/");
        for(String s : p){
            if(s.equals(".") || s.isEmpty()) continue;
            if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } else {
                stack.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach((s)->{
            sb.append("/").append(s);
        });
        return sb.length() > 0 ? sb.toString() : "/";
    }
}