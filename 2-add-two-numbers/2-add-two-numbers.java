/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans1 = new ListNode();
        ListNode ans = ans1;
        boolean carry=false;
        while(true){
            int tmp = l1.val + l2.val + (carry?1:0);
            if(tmp>9) carry=true;
            else carry=false;
            ans.val = tmp%10;
            if(l1.next==null||l2.next==null){
                l1=l1.next;
                l2=l2.next;
                break;
            }
            ans.next=new ListNode();
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null&&l2!=null){
            while(l2!=null){
                ans.next=new ListNode();
                ans=ans.next;
                if(carry&&l2.val!=9) {
                    ans.val=l2.val+1;
                    carry=false;
                }
                else if(carry){
                    ans.val=0;
                    carry=true;
                }else{
                    ans.val=l2.val;
                    carry=false;
                }
                l2=l2.next;
            }
        }else if(l2==null&&l1!=null){
            while(l1!=null){
                ans.next=new ListNode();
                ans=ans.next;
                if(carry&&l1.val!=9) {
                    ans.val=l1.val+1;
                    carry=false;
                }
                else if(carry){
                    ans.val=0;
                    carry=true;
                }else{
                    ans.val=l1.val;
                    carry=false;
                }
                l1=l1.next;
            }
            
        }
        if(carry){
                ans.next=new ListNode(1);
        }
        return ans1;
    }
}