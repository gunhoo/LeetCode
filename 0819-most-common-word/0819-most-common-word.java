class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        for(String ban : banned) paragraph = paragraph.replaceAll(ban, "");
        String[] symbols = {"!", "?", "'", ",", ";", "."};
        System.out.println("--after ban--");
        System.out.println(paragraph);
        
        paragraph = paragraph.replaceAll("[!?',;.]", " ");
        System.out.println("--after removing symbols--");
        System.out.println(paragraph);
        
        String[] split = paragraph.trim().replaceAll("\\s+", " ").split(" ");
        System.out.println("--after--");
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : split){
            if(s.equals(" ")) continue;
            System.out.println(s);
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