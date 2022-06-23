import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        boolean odd = false;
        if(n%2==1) odd=true;
        int a=0;
        int b=0;
        int last = 0;
        int cnt=0;
        while(a<nums1.length && b<nums2.length && cnt < (n+1)/2){
            if(nums1[a]>nums2[b]){
                last=nums2[b];
                cnt++;
                b++;
            }else{
                last=nums1[a];
                a++;
                cnt++;
            }
        }
        
        if(a==nums1.length){//nums1 is too short
            if(n==1) return nums2[0];
            if(odd){
                if(cnt>=(n+1)/2) return last;
                while(cnt<n/2){
                    b++;
                    cnt++;
                }
                return nums2[b];
            }else{
                while(cnt<n/2){
                    last=nums2[b];
                    b++;
                    cnt++;
                }
                return ((double)nums2[b]+last)/2;
            }
        }else if(b==nums2.length){
            if(n==1) return nums1[0];
            if(odd){
                if(cnt>=(n+1)/2) return last;
                while(cnt<n/2){
                    a++;
                    cnt++;
                }
                return nums1[a];
            }else{
                while(cnt<n/2){
                    last=nums1[a];
                    a++;
                    cnt++;
                }
                return ((double)nums1[a]+last)/2;
            }
        }else{
            if(odd){
                return (double)last;
            }else{
                return (last+(double)Math.min(nums1[a], nums2[b]))/2;
            }
        }
        
    }
}