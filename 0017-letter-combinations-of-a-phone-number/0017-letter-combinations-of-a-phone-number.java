class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] letters = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        StringBuilder sb = new StringBuilder();
        List<String> answer = new ArrayList<>();
        helper(answer, letters, digits, sb, 0);
        return answer;
    }

    private void helper(List<String> list, String[][] letters, String digits, StringBuilder sb, int idx) {
        if(sb.length() == digits.length()) {
            list.add(new String(sb.toString()));
            return;
        }
        for(int i=0; i<letters[digits.charAt(idx)-'2'].length; i++){
            sb.append(""+letters[digits.charAt(idx)-'2'][i]);
            helper(list, letters, digits, sb, idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}