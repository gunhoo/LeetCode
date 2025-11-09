class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> dq = new Stack<>();
        for(int currDate=0; currDate<temperatures.length; currDate++){
            int currTemp = temperatures[currDate];
            while(!dq.isEmpty() && temperatures[dq.peek()] < currTemp){
                int prevDate = dq.pop();
                answer[prevDate] = currDate - prevDate; 
            }
            dq.push(currDate);
        }
        return answer;
    }
}