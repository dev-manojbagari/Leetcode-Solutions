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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null)
            return head;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        int length = getLength(head);
        k = k%length;
        if(k==0)
            return head;
        int count =1;
        while(count!=k+1){
            ptr2=ptr2.next;
            count++;
        }
        
        while(ptr2.next!=null){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        ListNode newHead = ptr1.next;
        ptr1.next=null;
        ptr2.next=head;
        
        return newHead;
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


