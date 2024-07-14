class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<>();
        char[] geneCharArray = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        q.add(startGene);
        set.add(startGene);
        int answer = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String node = q.remove();
                if(node.equals(endGene)) return answer;
                
                for(char c: geneCharArray){
                    for(int j=0; j<node.length(); j++){
                        String next = node.substring(0,j) + c + node.substring(j+1);
                        if(!set.contains(next) && Arrays.asList(bank).contains(next)){
                            q.add(next);
                            set.add(next);
                        }
                    }
                }
            }
            answer += 1;
        }
        return -1;
    }
}