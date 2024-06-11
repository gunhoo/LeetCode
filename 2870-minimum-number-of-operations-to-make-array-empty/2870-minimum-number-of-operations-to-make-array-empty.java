class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        for(int cnt : map.values()){
            if(cnt % 3 == 0){
                ans += (cnt/3);
            } else {
                cnt -= 2;
                ans += 1;
                while(cnt > 0){
                    if( cnt % 3 == 0){
                        ans += (cnt / 3);
                        break;
                    }
                    cnt -= 2;
                    ans += 1;
                }
                if( cnt < 0) return -1;
            }
        }
        return ans;
    }
}