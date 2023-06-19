import java.util.*;

class Solution {
    public int myAtoi(String s) {
        StringBuilder answer = new StringBuilder("");
        for(int i =0 ;i < s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(answer.toString().length() == 1) return 0;
                if(answer.toString().length() == 0) answer.append(s.charAt(i));
                else break;
            }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                answer.append(s.charAt(i));
            }else{
                if(' ' == s.charAt(i) && answer.toString().length() == 0) continue;
                else break;
            }
        }
        String ans = answer.toString();
        answer = new StringBuilder("");
        for(int i =0 ;i < ans.length(); i++){
            if(ans.charAt(i) == '0' && ("".equals(answer.toString()) || "+".equals(answer.toString()) || "-".equals(answer.toString()) )) continue;
            answer.append(ans.charAt(i));
        }
        ans = answer.toString();
        if("".equals(answer.toString()) || "+".equals(ans) || "-".equals(ans)) return 0;
        if(ans.charAt(0) == '-' && (ans.length() > 11 || Long.parseLong(ans) < Integer.MIN_VALUE)) return Integer.MIN_VALUE;
        if(ans.length() > 11 || Long.parseLong(ans) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return Integer.parseInt(answer.toString());
    }
}