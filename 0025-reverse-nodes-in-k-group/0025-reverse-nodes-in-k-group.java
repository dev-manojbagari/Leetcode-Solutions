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
        if(k==1) return head;
        int freq = getLen(head)/k;
                
        return reverse(head,k,freq);
    }
    
    ListNode reverse(ListNode head,int k,int freq){
        if(freq==0||head==null)
            return head;
        ListNode prev =null,curr=head,next=null;
        int count=0;
        while(curr!=null&&count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        
        head.next= reverse(next,k,freq-1);
       
        return prev;
    }
    
    int getLen(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
    
}