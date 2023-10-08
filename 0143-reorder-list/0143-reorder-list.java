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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next=null;
        ListNode ptr1 = head;
        ListNode ptr2 = reverse(midNext);
        
        while(ptr2!=null){
            ListNode temp = ptr2.next;
            ptr2.next=ptr1.next;
            ptr1.next=ptr2;
            ptr1=ptr1.next.next;
            ptr2=temp;
        }
    }
    
    ListNode getMid(ListNode head){
        ListNode slow = head,fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null,curr=head,next=null;
        
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    
}