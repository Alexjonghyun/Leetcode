import java.util.Stack;

class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            if(s.length() - i < answer.length()/2 ) break;
            //case1:abcba
            int j=1;
            boolean expanded = false;
            while(true) {
                if (i - j > -1 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                    expanded=true;
                    j++;
                }else{
                    break;
                }
            }
            if(expanded && answer.length()<2*j-1){
                answer = s.substring(i-j+1, i+j);
            }
            //case2:abba
            j=1;
            expanded = false;
            while(true) {
                if (i - j + 1 > -1 && i + j < s.length() && s.charAt(i - j + 1) == s.charAt(i + j)) {
                    expanded=true;
                    j++;
                }else{
                    break;
                }
            }
            if(expanded && answer.length()<2*j-2){
                answer = s.substring(i-j+2, i+j);
            }
        }
        if(answer.length()==0) return s.substring(0,1);
        return answer;
    }
}