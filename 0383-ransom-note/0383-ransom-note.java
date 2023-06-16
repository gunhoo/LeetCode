class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] remainLetters = new int[26];
        
        for(int i = 0 ; i < magazine.length(); i++){
            remainLetters[magazine.charAt(i)-'a'] += 1;
        }
        for(int i = 0 ; i < ransomNote.length(); i++){
            if(remainLetters[ransomNote.charAt(i)-'a'] <= 0) return false;
            remainLetters[ransomNote.charAt(i)-'a'] -= 1;
        }
        return true;
    }
}