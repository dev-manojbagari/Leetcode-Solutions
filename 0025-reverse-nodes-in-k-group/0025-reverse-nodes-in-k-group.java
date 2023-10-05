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
                
        ListNode preHead = new ListNode(-1);
        ListNode ptr = preHead;
        ListNode curr = head;
        
        for(int i=0;i<freq;i++){
            ListNode firstNodeInGroup = curr;
            int count=0;
            while(curr!=null&&count<k){
                ListNode temp = curr.next;
                curr.next=ptr.next;
                ptr.next = curr;
                curr=temp;
                count++;
            }
            
            ptr = firstNodeInGroup;
        }
        
        if(curr!=null)
            ptr.next=curr;
        
        
        
        
        
        return preHead.next;
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