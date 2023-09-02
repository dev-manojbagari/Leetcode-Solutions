/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return head;
        ListNode slow = head,fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
                
                return cycleHead(head,slow);
            }
        }
        
        return null;
    }
    
    ListNode cycleHead(ListNode head,ListNode node){
        int len = findCycleLength(node);
        
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        int count =0;
        while(count!=len){
            ptr2=ptr2.next;
            count++;
        }
        
        while(ptr2.next!=ptr1){
            System.out.println(2);
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        
        return ptr1;
        
    }
    
    
    int findCycleLength(ListNode node){
        ListNode curr = node;
        int count =0;
        while(curr.next!=node){
            curr= curr.next;
            count++;
        }
        return count;
    }
    
    
    
}