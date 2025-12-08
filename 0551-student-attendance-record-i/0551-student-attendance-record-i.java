class Solution {
    public boolean checkRecord(String s) {
        int totalAbsent = 0;
        int consecutiveLate = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'A') {
                totalAbsent += 1;
                consecutiveLate = 0;
                if(totalAbsent >= 2) return false;
            } else if(s.charAt(i) == 'L'){
                consecutiveLate += 1;
                if(consecutiveLate == 3) return false;
            } else {
                consecutiveLate = 0;
            }
        }
        return true;
    }
}