import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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