class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a'] += 1;
        }
        for(int i=0; i<t.length(); i++){
            if(count[t.charAt(i)-'a'] == 0 ) return t.charAt(i);
            count[t.charAt(i)-'a']-=1;
        }
        return 'a';
    }
}