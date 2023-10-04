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
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        
        ListNode newHead = head.next;
        ListNode preHead= new ListNode(-1);
        preHead.next=head;
        ListNode prev = preHead;
        ListNode curr = head;
        
        while(curr!=null&&curr.next!=null){
            ListNode temp = curr.next;
            curr.next = curr.next.next;
            temp.next = curr;
            prev.next=temp;
            prev=curr;
            curr= curr.next;
            
        }
        
        return newHead;
    }
}