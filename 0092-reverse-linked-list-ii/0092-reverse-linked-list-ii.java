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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev=null;
        ListNode curr=head;
        int count =1;
        while(count!=left){
            prev=curr;
            curr=curr.next;
            count++;
        }
        
        if(prev!=null)
            prev.next = reverse(curr,left,right);
        else
            head= reverse(curr,left,right);
        
        return head;
    }
    
      public ListNode reverse(ListNode head,int curPos,int rightPos) {
        ListNode prev=null,curr=head,next=null;
        int count =curPos;
        while(count<=rightPos){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        
          if(next!=null)
              head.next=next;
         
        return prev;
    }
}