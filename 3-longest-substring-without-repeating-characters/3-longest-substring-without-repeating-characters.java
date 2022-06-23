import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //if(s.length()==1) return 1;
        if(s.length()==0) return 0;
        int answer = 0;
        int cnt = 0;
        int ptr = 0;
        HashMap<Character, Integer> db = new HashMap<>();
        while(ptr<s.length()){
            if(db.get(s.charAt(ptr))==null){
                db.put(s.charAt(ptr), ptr);
                cnt++;
                ptr++;
                if(cnt>answer) answer=cnt;
            }else{
                if(cnt>answer) answer=cnt;
                ptr=db.get(s.charAt(ptr))+1;
                cnt=0;
                db.clear();
            }
        }
        
        return answer;
        
    }
}
