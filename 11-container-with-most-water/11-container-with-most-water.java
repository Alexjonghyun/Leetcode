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
//Above is a greedy way
//Without greedy way, I could make


/*
import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        int lowestHeight = Integer.MAX_VALUE;
        int highestHeight = -1;
        boolean[] existHeight = new boolean[10001];
        boolean[] usedIdx = new boolean[height.length];
        for (int i = 0; i < height.length; i++) {
            if(map.get(height[i])==null){
                map.put(height[i], new ArrayDeque<Integer>());
            }
            if(height[i]>highestHeight) highestHeight = height[i];
            if(height[i]<lowestHeight) lowestHeight = height[i];
            existHeight[height[i]] = true;
            map.get(height[i]).addLast(i);
        }
        if(lowestHeight==0) {
            lowestHeight=1;
            for (int t:
                    map.get(0)) {
                usedIdx[t] = true;
            }
        }

        int scale=0;
        //LinkedList<Integer> unusedIdx = new LinkedList<>();
        int remainingBiggest = height.length-1;
        int remainingSmallest = 0;
        while(!usedIdx[remainingSmallest]){
            remainingSmallest++;
        }
        while(!usedIdx[remainingBiggest]){
            remainingBiggest--;
        }

        for (int i = lowestHeight; i < highestHeight+1; i++) {
            if(!existHeight[i]) continue;
            ArrayDeque<Integer> mm = map.get(i);
            int smallestIdx = mm.peekFirst();
            int biggestIdx = mm.peekLast();
            scale = Math.max((remainingBiggest - smallestIdx) * i, scale);

            scale = Math.max((biggestIdx - remainingSmallest) * i, scale);

            for (int t:
                    mm) {
                usedIdx[t] = true;
            }//이미 쓰인 인덱스는 안씀 - 더 커야지만 로직이 성립하니까

            //remainingBIG,SMALL 관리해주는 로직 추가
            while(!usedIdx[remainingSmallest]){
                remainingSmallest++;
            }
            while(!usedIdx[remainingBiggest]){
                remainingBiggest--;
            }
        }
        return scale;


    }
}
*/