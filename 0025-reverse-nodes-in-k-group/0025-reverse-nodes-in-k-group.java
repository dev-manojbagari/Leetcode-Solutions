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
        if(freq==0)
            return head;
        
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        ListNode curr= head;
        
        while(freq>0){
            ListNode firstNode = curr;;
            for(int i=0;i<k;i++){
                ListNode temp = curr;
                curr=curr.next;
                temp.next=null;
                temp.next=pre.next;
                pre.next=temp;
            }
            freq--;
            if(freq>0){
                pre = firstNode;
            }else{
                firstNode.next=curr;
            }
            
        
        }
        
        return preHead.next;       
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