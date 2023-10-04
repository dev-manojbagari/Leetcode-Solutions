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
        if(head==null||head.next==null||left==right) return head;
        int count=1;
        ListNode preHead= new ListNode(-1);
        preHead.next=head;
        ListNode prev=preHead;
        ListNode curr=head;;
        while(count!=left){
            prev=curr;
            curr=curr.next;
            count++;
        }
        
        
        prev.next= reverseBetween(curr,right-left+1);
        
        return preHead.next;
    }
    
    ListNode reverseBetween(ListNode head,int count){
        ListNode prev=null,curr=head,next=null;
        
        while(curr!=null&&count>0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count--;
        }
        
        if(next!=null)
            head.next=next;
        
        return prev;
        
    }
}