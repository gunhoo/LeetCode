class Solution {
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> generate(int numRows) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        list.add(tmp);
        if (numRows == 1) return list;
        tmp = new ArrayList<>();
        tmp.add(1); tmp.add(1);
        list.add(tmp);
        if(numRows == 2) return list;
        for (int i = 2; i < numRows ; i++) {
            List<Integer> dp = new ArrayList<>();
            List<Integer> prev = list.get(list.size()-1);
            dp.add(1);
            for (int j = 1; j < prev.size() ; j++) {
                dp.add(prev.get(j-1)+prev.get(j));
            }
            dp.add(1);
            list.add(dp);
        }
        return list;
    }
}