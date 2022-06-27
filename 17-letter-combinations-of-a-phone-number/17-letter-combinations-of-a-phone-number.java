import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayDeque<String> dq = new ArrayDeque<>();
        for(int i=0; i<digits.length(); i++){
            char in1 = ' ';
            char in2 = ' ';
            char in3 = ' ';
            char in4 = ' ';
            if(digits.charAt(i)=='2'){
                in1='a';
                in2='b';
                in3='c';
            }else if(digits.charAt(i)=='3'){
                in1='d';
                in2='e';
                in3='f';
            }else if(digits.charAt(i)=='4'){
                in1='g';
                in2='h';
                in3='i';
            }else if(digits.charAt(i)=='5'){
                in1='j';
                in2='k';
                in3='l';
            }else if(digits.charAt(i)=='6'){
                in1='m';
                in2='n';
                in3='o';
            }else if(digits.charAt(i)=='7'){
                in1='p';
                in2='q';
                in3='r';
                in4='s';
            }else if(digits.charAt(i)=='8'){
                in1='t';
                in2='u';
                in3='v';
            }else if(digits.charAt(i)=='9'){
                in1='w';
                in2='x';
                in3='y';
                in4='z';
            }
            
            if(!dq.isEmpty()){
                int n = dq.size();
                for(int j=0; j<n; j++){
                    String tmp = dq.pollFirst();
                    dq.addLast(tmp.concat(Character.toString(in1)));
                    dq.addLast(tmp+Character.toString(in2));
                    dq.addLast(tmp+Character.toString(in3));
                    if(in4!=' ') dq.addLast(tmp+Character.toString(in4));
                }
                
            }else{
                dq.addLast(Character.toString(in1));
                dq.addLast(Character.toString(in2));
                dq.addLast(Character.toString(in3));
                if(in4!=' ') dq.addLast(Character.toString(in4));
            }
        }
        
        return new ArrayList(dq);
    }
}