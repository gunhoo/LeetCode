class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        boolean five, three;
        for(int i = 1 ; i <= n; i++){
            five = ( i % 5 == 0) ? true : false;
            three = (i % 3 == 0) ? true : false;
            if(five && three){
                answer.add("FizzBuzz");
            }else if(three){
                answer.add("Fizz");
            }else if(five){
                answer.add("Buzz");
            }else{
                answer.add(""+i);
            }
        }
        return answer;
    }
}