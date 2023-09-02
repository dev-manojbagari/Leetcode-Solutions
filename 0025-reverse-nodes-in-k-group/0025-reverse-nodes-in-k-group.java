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
// 
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        return reverse(head,k,len/k);
    }
    
    ListNode reverse(ListNode head,int k,int freq){
        ListNode prev = null,curr=head,next=null;
        int count =0;
        
        while(curr!=null&&count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        freq--;
        if(curr!=null&&freq>0)
            head.next = reverse(curr,k,freq);
        else
            head.next=curr;
        
        return prev;
        
    }
    
    int getLength(ListNode node){
        int count =0;
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
    
}