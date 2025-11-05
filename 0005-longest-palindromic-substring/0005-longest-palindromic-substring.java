class Solution {
    public String longestPalindrome(String s) {
        String answer = String.valueOf(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            String evenPalindrom = findPalindrom(s, i, i);
            String oddPalindrom = findPalindrom(s, i-1, i);
            if(evenPalindrom.length() > answer.length()) {
                answer = evenPalindrom; 
            }
            if(oddPalindrom.length() > answer.length()) {
                answer = oddPalindrom; 
            }
        }
        return answer;
    }

    private String findPalindrom(String s, int left, int right){
        int l = left, r = right;
        StringBuilder sb = new StringBuilder();
        while(l>=0 && r<s.length()){
            if(s.charAt(l) == s.charAt(r)) {
                l--; r++;
            } else {
                l++; r--;
                break;
            }
        }
        if(l<0 || r>=s.length()) {
            l++; r--;
        }
        for(int i=l; i<=r; i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}