class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int max = 0; int min = 0;
        if(nums1.length > nums2.length ){
            max = nums1.length;
            min = nums2.length;
        }else{
            max = nums2.length;
            min = nums1.length;
        }
        boolean[] visited = new boolean[max];
        List<Integer> answer = new ArrayList<>();
        
        if(nums1.length> nums2.length) {
            for(int i = 0 ; i < min ; i++){
                for(int j = 0 ; j < max; j++){
                    if( nums1[j] == nums2[i] && !visited[j]){
                        visited[j] = true;
                        answer.add(nums1[j]);
                        break;
                    }
                }
            }
        }else{
            for(int i = 0 ; i < min ; i++){
                for(int j = 0 ; j < max; j++){
                    if( nums2[j] == nums1[i] && !visited[j]){
                        visited[j] = true;
                        answer.add(nums2[j]);
                        break;
                    }
                }
            }
        }
        int[] ans = new int[answer.size()];
        for(int i = 0 ; i < answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}