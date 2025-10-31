class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(i%3==0){
                if(i%5==0){
                    answer.add(new String("FizzBuzz"));
                } else {
                    answer.add(new String("Fizz"));
                }
            } else if(i%5==0){
                answer.add(new String("Buzz"));
            } else {
                answer.add(String.valueOf(i));
            }
        }
        
        return answer;
    }
}