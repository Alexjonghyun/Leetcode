import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(st.isEmpty()) st.addLast(s.charAt(i));
            else if(st.peekLast()==s.charAt(i)-1||st.peekLast()==s.charAt(i)-2) {
                st.pollLast();
                continue;
            }
            else st.addLast(s.charAt(i));
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}