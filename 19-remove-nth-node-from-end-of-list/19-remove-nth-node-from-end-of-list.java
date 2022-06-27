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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode out = head;
        ListNode start = head;
        int length=1;
        while(head.next!=null){
            head = head.next;
            length++;
        }
        if(length==n) return out.next;
        for(int i=0; i<length-n-1; i++){
            start = start.next;
        }
        start.next = start.next.next;
        
        return out;
    }
}