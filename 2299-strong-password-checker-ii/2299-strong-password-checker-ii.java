class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean[] passwordChecker = new boolean[4];
        if(password.length() < 8) return false;
        
        for(int i = 0 ; i < password.length() ; i++){
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') passwordChecker[0] = true;
            else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') passwordChecker[1] = true;
            else if(password.charAt(i) >= '0' && password.charAt(i) <= '9') passwordChecker[2] = true;
            else if(password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#'
                   || password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^' ||
                   password.charAt(i) == '&' || password.charAt(i) == '*' || password.charAt(i) == '(' ||
                   password.charAt(i) == ')' || password.charAt(i) == '-' || password.charAt(i) == '+') passwordChecker[3] = true;
            if(i >= 1 && password.charAt(i-1) == password.charAt(i)) return false;
        }
        for(int i = 0 ; i < 4; i++) if(!passwordChecker[i]) return false;
        return true;
    }
}