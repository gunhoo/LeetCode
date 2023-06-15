import java.util.*;

class Solution {
    public String reorderSpaces(String text) {
        int numOfSpaces = 0;
        StringTokenizer st = new StringTokenizer(text);
        
        StringBuilder newText = new StringBuilder("");
        for(int i = 0 ; i < text.length(); i++){
            if(text.charAt(i) == ' ') numOfSpaces++;
        }
        if(st.countTokens() == 1) {
            newText.append(st.nextToken());
            for(int i =0 ; i < numOfSpaces; i++) newText.append(" ");
            return newText.toString();
        }
        
        int between = numOfSpaces / (st.countTokens()-1);
        int end = numOfSpaces % (st.countTokens()-1);

        while(st.hasMoreTokens()){
            newText.append(st.nextToken());
            if(st.hasMoreTokens()){
                for(int i = 0 ; i < between ; i++){
                    newText.append(" ");
                }
            }
        }
        for(int i = 0 ; i < end ; i++){
            newText.append(" ");
        }
        
        return newText.toString();
    }
}