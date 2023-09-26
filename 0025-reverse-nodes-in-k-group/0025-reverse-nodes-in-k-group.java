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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLen(head);
        int freq = len/k;
        // System.out.println(freq);
        return reverse(head,k,freq);
    }
    
    public ListNode reverse(ListNode head,int k,int freq){
        if(head==null||freq==0)
            return head;
        ListNode prev=null,curr=head,next=null;
        int count =0;
        while(curr!=null&&count<k){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
    
        if(next!=null)
            head.next = reverse(next,k,--freq);
        
        return prev;
    }
    
    int getLen(ListNode node){
        int count=0;
        while(node!=null){
            node=node.next;
            count++;
        }
        return count;
    }
    
}