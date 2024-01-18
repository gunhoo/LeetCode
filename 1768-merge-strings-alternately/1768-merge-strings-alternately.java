class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        if(word1.length() >= word2.length()){
            return mergeString(word1, word2, false);
        }
        return mergeString(word1, word2, true);
        
    }
    
    private String mergeString(String a, String b, boolean tf) {
        
        StringBuilder sb = new StringBuilder();
        if(tf) {
            for(int i=0; i<a.length(); i++){
                sb.append(a.charAt(i)).append(b.charAt(i));
            }
            for(int i=a.length(); i<b.length(); i++){
                sb.append(b.charAt(i));
            }
        } else {
            sb.append(a.charAt(0)).append(b.charAt(0));
            for(int i=1; i<b.length(); i++){
                sb.append(a.charAt(i)).append(b.charAt(i));
            }
            for(int i=b.length(); i<a.length(); i++){
                sb.append(a.charAt(i));
            }
        }
        
        return sb.toString();
    }
}