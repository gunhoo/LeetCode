class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new LinkedList<>();
        backtracking(answer, "", 0, 0, n);
        return answer;
    }
    
    private void backtracking(List<String> list, String s, int open, int close, int max){
        if(s.length() == max*2){
            list.add(s);
            return;
        }
        
        if(open < max) backtracking(list, s+"(", open+1, close, max);
        if(close < open) backtracking(list, s+")", open, close+1, max);
    }
}