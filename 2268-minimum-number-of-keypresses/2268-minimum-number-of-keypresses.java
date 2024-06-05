class Solution {
    public int minimumKeypresses(String s) {
        int[] numbers = new int[26];
        for(char c : s.toCharArray()){
            numbers[c-'a']++;
        }
        int ans = 0;
        Arrays.sort(numbers);
        for(int i=0; i<8; i++){
            if(numbers[i] != 0) ans += 3*numbers[i];
        }
        for(int i=8; i<17; i++){
            if(numbers[i] != 0) ans += 2*numbers[i];
        }
        for(int i=17; i<26; i++){
            if(numbers[i] != 0) ans += 1*numbers[i];
        }
        return ans;
    }
}