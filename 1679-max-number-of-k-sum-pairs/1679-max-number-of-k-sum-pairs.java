class Solution {
    public int maxOperations(int[] nums, int k) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            int complement = k - current;
            if(map.getOrDefault(complement,0) > 0){
                map.put(complement, map.getOrDefault(complement,0)-1);
                answer += 1;
            } else {
                map.put(current, map.getOrDefault(current, 0)+1);
            }
        }
        return answer;
    }
}