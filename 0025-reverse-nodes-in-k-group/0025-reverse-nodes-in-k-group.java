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
        
        
        ListNode preHead= new ListNode(-1);
        ListNode curr= head;
        ListNode ptr=preHead;
        
        for(int i=0;i<freq;i++){
            ListNode firstNodeInGroup = curr;
            int count =0;
            while(count<k){
                ListNode temp= curr;
                curr=curr.next;
                temp.next=ptr.next;
                ptr.next=temp;
                count++;
            }
            ptr = firstNodeInGroup;
        }
        
        if(curr!=null)
            ptr.next=curr;
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