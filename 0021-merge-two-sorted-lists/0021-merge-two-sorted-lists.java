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
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        ListNode temp = null;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                temp = list1;
                list1=list1.next;
                temp.next=null;
            }else{
                temp = list2;
                list2=list2.next;
                temp.next=null;
            }
            
            curr.next=temp;
            curr=curr.next;
        }
        
        if(list1!=null)
            curr.next=list1;
        else if(list2!=null)
            curr.next=list2;
        
        return preHead.next;
    }
}