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
        
        ListNode preHead = new ListNode(-1);
        ListNode curr =preHead,temp=null;
        int count=1;
        
        while(ptr2!=null){
            if(count%2!=0){
                temp = ptr1;
                ptr1=ptr1.next;
                temp.next=null;
            }else{
                temp = ptr2;
                ptr2=ptr2.next;
                temp.next=null;
            }
            curr.next=temp;
            curr=curr.next;
            count++;
        }
        if(ptr1!=null)
            curr.next=ptr1;
        head=preHead.next;
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