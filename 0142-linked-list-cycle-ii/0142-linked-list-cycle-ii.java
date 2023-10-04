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
        if(head==null||head.next==null)
           return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                ListNode slow1 = slow;
                ListNode slow2 = head;
                
                while(slow1!=slow2){
                    slow1=slow1.next;
                    slow2=slow2.next;
                }
                return slow1;
            }
        }
        
        return null;
    }  
}