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
        if(k==1)
            return head;
        int len = getLen(head);
        int freq = len/k;
        
        ListNode preHead = new ListNode(-1);
        ListNode ptr=preHead;
        ListNode curr = head;
        for(int i=0;i<freq;i++){
            ListNode firstNodeInGroup = curr;
            for(int count=0;count<k;count++){
                ListNode next = curr.next;
                curr.next = ptr.next;
                ptr.next=curr;
                curr= next;
            }   
            
            if(curr!=null){
                ptr=firstNodeInGroup;
            }else{
                break;
            }
            
        }
        if(curr!=null)  
            ptr.next = curr;
        
        return preHead.next;
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