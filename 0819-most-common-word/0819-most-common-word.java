class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        for(String ban : banned) paragraph = paragraph.replaceAll(ban, "");
        String[] symbols = {"!", "?", "'", ",", ";", "."};
        
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        
        String[] split = paragraph.trim().replaceAll("\\s+", " ").split(" ");
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : split){
            if(s.equals(" ")) continue;
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }else{
                map.put(s, 1);
            }
        }
        String answer = ""; int max = 0;
        for(String key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}