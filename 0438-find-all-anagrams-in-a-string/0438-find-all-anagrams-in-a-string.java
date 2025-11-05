class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList<>();
        if(p.length() > s.length()) return answer;
        int[] counts = new int[26];
        int[] window = new int[26];
        for(char c : p.toCharArray()) counts[c-'a'] += 1;
        for(int i=0; i<p.length(); i++){
            window[s.charAt(i)-'a'] += 1;
        }
        if(anagram(window, counts)) answer.add(0);
        for(int i=1; i<s.length()-p.length()+1; i++){
            window[s.charAt(i-1)-'a']-=1;
            window[s.charAt(i+p.length()-1)-'a']+=1;
            if(anagram(window, counts)) answer.add(i);
        }
        return answer;
    }

    private boolean anagram(int[] a, int[] b){
        for(int i=0; i<26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}