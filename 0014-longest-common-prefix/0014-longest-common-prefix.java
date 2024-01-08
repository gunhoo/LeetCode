class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        else if(strs.length == 1 || strs[0].equals("")) return strs[0];
        String prefix = strs[0];
        for (int i = 1; i < strs.length ; i++) {
            if(strs[i].equals("")) return "";
            StringBuilder answer = new StringBuilder();
            int c = 0;
            while(prefix.charAt(c) == strs[i].charAt(c) ){
                answer.append(strs[i].charAt(c));
                c++;
                if(c >= prefix.length() || c >= strs[i].length()) break;
            }
            if( c == 0) return "";
            else prefix = answer.toString();
        }
        return prefix;
    }
}