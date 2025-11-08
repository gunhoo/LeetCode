class Solution {
    public int singleNumber(int[] nums) {
        // I need a set to store the numbers
        // iterate nums, find num in set -> if exists: remove else: add the number into the set
        // after iterating all nums, return the remaining set value
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return (int)set.toArray()[0];
    }
}