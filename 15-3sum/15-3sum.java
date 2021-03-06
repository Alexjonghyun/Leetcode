import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hm.get(nums[i])==null) hm.put(nums[i], 1);
            else if(hm.get(nums[i])<3) hm.put(nums[i], hm.get(nums[i])+1);
        }
        ArrayList<Integer> setList = new ArrayList<>(hm.keySet());
        Collections.sort(setList);
        for (int i=0; i<setList.size(); i++) {
            int t = setList.get(i);
            if(t==0){
                if (hm.get(t)>2) {
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(0);
                    tmp.add(0);
                    tmp.add(0);
                    ans.add(tmp);
                }
                continue;
            }
            if(hm.get(t)>1) { //t를 두개, t가 아닌걸 하나 조합해서 0이 되는 경우 구하기
                if(hm.get(-2*t)!=null){
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(t);
                    tmp.add(t);
                    tmp.add(-2*t);
                    ans.add(tmp);
                }
            }
            if(t>0) continue;
            //세 원소가 모두 다른경우를 구하기
            for (int j = i+1; j < setList.size(); j++) {
                int t2 = setList.get(j); // t!=t2
                if(t2<-t-t2 && hm.get(-t-t2)!=null){
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(t);
                    tmp.add(t2);
                    tmp.add(-t-t2);
                    ans.add(tmp);
                }
            }

        }
        return ans;
    }
}

/* First Solution
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        boolean zero = false;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Boolean> dup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]) {
                    if (nums[i]!=0&&dup.get(nums[i]) == null) {
                        dup.put(nums[i], true);
                        if(hm.get(-2*nums[i])!=null){
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[i]);
                            tmp.add(-2*nums[i]);
                            ans.add(tmp);
                        }
                    } else {
                        if(nums[i]==0&&!zero){
                            if(hm.get(0)==i||hm.get(0)==j) continue;
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(0);
                            tmp.add(0);
                            tmp.add(0);
                            ans.add(tmp);
                            zero = true;
                        }
                    }
                    continue;
                }
                if(hm.get(nums[i]) != i || hm.get(nums[j])!=j) continue;
                if(hm.get(-nums[i]-nums[j])!=null&&hm.get(-nums[i]-nums[j])!=i&&hm.get(-nums[i]-nums[j])!=j&&hm.get(-nums[i]-nums[j])>i&&hm.get(-nums[i]-nums[j])>j){ // found 3sum case
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(-nums[i]-nums[j]);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }
}
*/