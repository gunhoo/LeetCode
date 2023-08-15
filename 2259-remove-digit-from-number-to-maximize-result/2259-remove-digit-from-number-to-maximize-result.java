class Solution {
    public String removeDigit(String number, char digit) {
        int idx = 0;
        for(int i =0 ; i < number.length() ; i++){
            if(number.charAt(i) != digit) continue;
            idx = i;
            if(i != number.length()-1 && number.charAt(i) < number.charAt(i+1) ) {
                break;
            }
        }
        return number.substring(0, idx)+""+number.substring(idx+1);
    }
}