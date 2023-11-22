class Solution {
    public int minTimeToType(String word) {
        int answer = word.length();
        char prev = 'a';
        for(int i = 0 ; i < word.length(); i++){
            int diff = Math.abs(word.charAt(i) - prev);
            answer += Math.min(diff, 26-diff);
            prev = word.charAt(i);
        }
        return answer;
    }
}