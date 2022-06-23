class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int answer = 0;
        while(i<j){
            if(Math.min(height[i], height[j]) * (j-i) > answer){
                answer = Math.min(height[i], height[j])* (j-i);
            }
            if(height[i] > height[j]) j--;
            else i++;
            
        }
        return answer;
    }
}