class Solution {
    public boolean isPathCrossing(String path) {
        Map<Character, Pair<Integer, Integer>> map = new HashMap<>();
        map.put('N', new Pair(0, 1));
        map.put('S', new Pair(0, -1));
        map.put('W', new Pair(-1, 0));
        map.put('E', new Pair(1, 0));
        
        Set<Pair<Integer, Integer>> set = new HashSet();
        set.add(new Pair(0,0));
        
        int idx[] = {0,0};
        
        for (Character c : path.toCharArray()){
            Pair<Integer, Integer> dir = map.get(c);
            int dx = dir.getKey();
            int dy = dir.getValue();
            
            idx[0] += dx;
            idx[1] += dy;
            
            Pair<Integer, Integer> pair = new Pair(idx[0], idx[1]);
            if(set.contains(pair)) return true;
            set.add(pair);
        }
        
        return false;
    }
}