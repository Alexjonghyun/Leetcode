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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode answer = new ListNode();
        ListNode tmp = answer;
        while(list1!=null && list2!=null){ // while neither of them are empty
            tmp.next = new ListNode();
            if(list1.val<list2.val){
                tmp.val = list1.val;
                tmp = tmp.next;
                list1 = list1.next;
            }else if(list1.val >= list2.val){
                tmp.val = list2.val;
                tmp = tmp.next;
                list2 = list2.next;
            }
        }
        if(list1!=null){
            while(list1!=null){
                tmp.val = list1.val;
                list1=list1.next;
                if(list1!=null) {//more left in list1 -> then attach more node
                    tmp.next = new ListNode();
                    tmp = tmp.next;
                }
            }
        }else if(list2!=null){
            while(list2!=null){
                tmp.val = list2.val;
                list2=list2.next;
                if(list2!=null) {
                    tmp.next = new ListNode();
                    tmp = tmp.next;
                }
            }
        }
        return answer;
    }
}

//also available in recursive way :)
/*
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) 
            return list2;
        else if (list2 == null) {
            return list1;
        }
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

*/