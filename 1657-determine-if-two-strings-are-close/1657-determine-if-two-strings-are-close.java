class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if(n != m) return false;
        int[] word1Arr = new int[26], word2Arr = new int[26];
        for(char c : word1.toCharArray()){
            word1Arr[c-'a']+=1;
        }
        for(char c : word2.toCharArray()){
            word2Arr[c-'a']+=1;
        }
        for(int i=0; i<26; i++){
            if( (word1Arr[i] == 0 && word2Arr[i] > 0) ||
               (word1Arr[i] > 0 && word2Arr[i] == 0) ) 
                return false;
        }
        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        return Arrays.equals(word1Arr, word2Arr);
    }
}