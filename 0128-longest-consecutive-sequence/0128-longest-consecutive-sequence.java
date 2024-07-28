class Solution {
    public int longestConsecutive(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) set.add(n);
        
        for(int n : set){
            if(!set.contains(n-1)){
                int currentNum = n;
                int currentCons = 1;
                
                while(set.contains(currentNum+1)){
                    currentNum += 1;
                    currentCons += 1;
                }
                
                answer = Math.max(answer, currentCons);
            }
        }
        return answer;
    }
}