class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        helper(candidates, new ArrayList<>(), 0, 0, target);
        return ans;
    }

    private void helper(int[] candidates, List<Integer> candidate, int start, int currSum, int target){
        if(currSum > target) return;
        if(currSum == target){
            ans.add(new ArrayList<>(candidate));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            if(i>start && candidates[i] == candidates[i-1]) continue;
            candidate.add(candidates[i]);
            helper(candidates, candidate, i+1, currSum+candidates[i], target);
            candidate.remove(candidate.size()-1);
        }
    }
}