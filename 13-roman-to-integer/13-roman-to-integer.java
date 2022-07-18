class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        int i= 0;
        
        while(i!=s.length()){
            char t = s.charAt(i);
            if(t=='I'&& i!=s.length()-1 && s.charAt(i+1)!='V'&&s.charAt(i+1)!='X'){
                answer+=1;
            }else if(t=='I'&& i!=s.length()-1 && s.charAt(i+1)=='V'){
                answer+=4;
                i+=1;
            }else if(t=='I'&& i!=s.length()-1 && s.charAt(i+1)=='X'){
                answer+=9;
                i+=1;
            }else if(t=='I'){
                answer+=1;
            }else if(t=='V'){
                answer+=5;
            }else if(t=='X'&& i!=s.length()-1 && s.charAt(i+1)!='L'&&s.charAt(i+1)!='C'){
                answer+=10;
            }else if(t=='X'&& i!=s.length()-1 && s.charAt(i+1)=='L'){
                answer+=40;
                i+=1;
            }else if(t=='X'&& i!=s.length()-1 && s.charAt(i+1)=='C'){
                answer+=90;
                i+=1;
            }else if(t=='X'){
                answer+=10;
            }else if(t=='L'){
                answer+=50;
            }else if(t=='C'&& i!=s.length()-1 && s.charAt(i+1)!='D'&&s.charAt(i+1)!='M'){
                answer+=100;
            }else if(t=='C'&& i!=s.length()-1 && s.charAt(i+1)=='D'){
                answer+=400;
                i+=1;
            }else if(t=='C'&& i!=s.length()-1 && s.charAt(i+1)=='M'){
                answer+=900;
                i+=1;
            }else if(t=='C'){
                answer+=100;
            }else if(t=='D'){
                answer+=500;
            }else if(t=='M'){
                answer+=1000;
            }
            i++;
        }
        return answer;
        
    }
}