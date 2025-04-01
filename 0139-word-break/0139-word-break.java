class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int wordLength = s.length();
        boolean[] dp = new boolean[wordLength+1];
        dp[0] = true;

        for(int i=1; i<=wordLength; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[wordLength];
    }
}