import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        Deque<String> dq = new ArrayDeque<>();
        List<String> answer = new ArrayList<>();
        dq.addLast("1(");
        while(!dq.isEmpty()){
            String tmp = dq.pollFirst();
            if(tmp.charAt(0)== n+'0') {
                tmp = tmp.substring(1);
                while(tmp.length()!=2*n){
                    tmp+=")";
                }
                answer.add(tmp);
                continue;
            }
            if(tmp.charAt(0)-'0'>tmp.length()-1-(int)tmp.charAt(0)+'0') dq.addLast(tmp+')');
            int tmpFirstChar = tmp.charAt(0)+1;
            tmp = (char)tmpFirstChar + tmp.substring(1);
            dq.addLast(tmp+'(');
        }
        return answer;
    }
}