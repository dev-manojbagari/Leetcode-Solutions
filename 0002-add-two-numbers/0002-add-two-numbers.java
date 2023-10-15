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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0,carry=0;
        ListNode preHead=new ListNode(-1);
        ListNode curr = preHead;
        while(l1!=null||l2!=null){
            sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            
            curr.next = new ListNode(sum%10);
            curr=curr.next;
            carry = sum/10;
            sum=0;
        }
        if(carry>0)
            curr.next=new ListNode(carry);
        
        return preHead.next;
    }
}