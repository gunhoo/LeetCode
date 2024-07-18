class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks, Collections.reverseOrder());
        Collections.sort(processorTime);
        int answer = 0;
        for(int i=0; i<processorTime.size(); i++){
            for(int j=0; j<4; j++){
                answer = Math.max(answer, processorTime.get(i) + tasks.get(4*i+j));
            }
        }
        return answer;
    }
}