class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String afterSort = new String(charArray);
            
            if(!map.containsKey(afterSort)){
                map.put(afterSort, new ArrayList<>());
            }
            
            map.get(afterSort).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}