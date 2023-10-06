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
        
        int count=1;
        
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while(count!=n){
            ptr2=ptr2.next;
            count++;
        }
        
        ListNode prev = null;
        while(ptr2.next!=null){
            prev=ptr1;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        if(prev==null){
            head=head.next;
        }else{
            prev.next=ptr1.next;
            ptr1.next=null;
        }
        
        return head;
    }
}