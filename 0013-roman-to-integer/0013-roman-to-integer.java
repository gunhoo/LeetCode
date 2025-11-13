class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        char prev = s.charAt(0);

        if(s.length()==1) return romanToInt(prev);
        answer += romanToInt(prev);

        for(int i=1; i<s.length(); i++){
            char curr = s.charAt(i);
            answer = answer + romanToInt(curr) + calculateSubstraction(curr, prev);
            prev = curr;
        }
        return answer;
    }

    private int calculateSubstraction(char curr, char prev){
        switch(curr){
            case 'X': if(prev=='I') return -2; else return 0;
            case 'V': if(prev=='I') return -2; else return 0;
            case 'L': if(prev=='X') return -20; else return 0;
            case 'C': if(prev=='X') return -20; else return 0;
            case 'D': if(prev=='C') return -200; else return 0;
            case 'M': if(prev=='C') return -200; else return 0;
            default: return 0;
        }
    }

    private int romanToInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}