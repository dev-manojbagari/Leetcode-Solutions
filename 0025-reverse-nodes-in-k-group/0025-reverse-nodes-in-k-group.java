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
        return reverseKGroup(head,k,freq);
    }
    
    ListNode reverseKGroup(ListNode node,int k,int freq){
        if(freq==0||node==null)
            return node;
        
        ListNode prev=null,curr=node,next=null;
        int count=0;
        while(curr!=null&&count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        
        if(next!=null)
            node.next = reverseKGroup(next,k,freq-1);
        
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