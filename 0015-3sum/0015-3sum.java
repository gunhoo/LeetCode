class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            int l=i+1, r=nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]); list.add(nums[l]); list.add(nums[r]);
                    set.add(list);
                    l++;
                }
                else if(nums[i]+nums[l]+nums[r] < 0) l++;
                else r--;
            }
        }
        for(List<Integer> list: set){
            answer.add(list);
        }
        return answer;
    }
}

// 1. Brute force -> O(n^3) O(n)
// 2. Two pointers O(n^2)
// for i=0; i<nums.length-3; i++
//      int curr = nums[i];
//      int l=i+1, r=nums.length-1;
//      while(l<r)
//          if(nums[i]+nums[l]+nums[r] == 0) answer.add(new ArrayList<>({i, l, r}));
//          if(nums[i]+nums[l]+nums[r] < 0) l++;
//          else r--;
//  return answer;