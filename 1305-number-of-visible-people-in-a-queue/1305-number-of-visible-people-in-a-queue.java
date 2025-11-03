class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] <= heights[i]){
                answer[stack.pop()] += 1;
            }
            if(!stack.isEmpty()){
                answer[stack.peek()] += 1;
            }
            stack.add(i);
        }
        return answer;
    }
}