import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(st.isEmpty()) st.add(s.charAt(i));
            else if(st.peek()==s.charAt(i)-1||st.peek()==s.charAt(i)-2) {
                st.pop();
                continue;
            }
            else st.add(s.charAt(i));
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}