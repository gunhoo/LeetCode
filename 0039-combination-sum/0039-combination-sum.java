class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] candidates, int remain, int start){
        if(remain < 0 ) return;
        if(remain == 0) list.add(new ArrayList<>(tmpList));
        else {
            for(int i=start; i<candidates.length; i++){
                tmpList.add(candidates[i]);
                backtrack(list, tmpList, candidates, remain-candidates[i], i);
                tmpList.remove(tmpList.size()-1);
            }
        }
    }
}