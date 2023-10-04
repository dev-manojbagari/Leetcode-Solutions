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
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        
        ListNode mid = getMid(head);
        ListNode midNext=mid.next;
        midNext = reverse(mid.next);        
        mid.next=null;
        
        ListNode ptr1=head;
        ListNode ptr2=midNext;
        
        while(ptr1!=null&&ptr2!=null){
            
            if(ptr1.val!=ptr2.val)
                return false;
            
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        mid.next = reverse(midNext);
        
        return true;
    }
    
    ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    ListNode reverse(ListNode head){
        ListNode prev=null,curr=head,next=null;
        
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        return prev;
    }
    
    
    
}