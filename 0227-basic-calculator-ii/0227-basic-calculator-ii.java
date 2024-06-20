class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        System.out.println(s);
        int prev=0, curr=0, i=0, answer=0;
        char sign = '+';
        while(i<s.length()){
            curr = 0;
            while(i<s.length() && Character.isDigit(s.charAt(i))){
                curr = (curr*10) + (s.charAt(i)-'0');
                i++;
            }
            if(sign == '+'){
                answer += prev;
                prev = curr;
            } else if(sign == '-'){
                answer += prev;
                prev = -curr;
            } else if(sign == '*'){
                prev = prev * curr;
            } else {
                prev = prev / curr;
            }
            
            if(i<s.length()){
                sign = s.charAt(i);
                i++;
            }
            
        }
        answer += prev;
        return answer;
    }
}