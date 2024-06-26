class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        String[] ans = new String[numRows];
        boolean down = true;
        int iterator = 0;
        for(int i=0; i<numRows; i++) ans[i] = "";
        for(int i=0; i<s.length(); i++){
            if(down){
                ans[iterator] += s.charAt(i);
                if(iterator == numRows-1){
                    down = false;
                    iterator -= 1;
                } else {
                    iterator += 1;
                }
            } else {
                ans[iterator] += s.charAt(i);
                if(iterator == 0){
                    down = true;
                    iterator += 1;
                } else {
                    iterator -= 1;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<numRows; i++){
            answer.append(ans[i]);
        }
        return answer.toString();
    }
}