/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        
        ListNode big = lenA>=lenB?headA:headB;
        ListNode small = big==headA?headB:headA;
        
        int diff = Math.abs(lenA-lenB);
        
        while(diff!=0){
            big = big.next;
            diff--;
        }
        
        while(small!=big){
            big=big.next;
            small=small.next;
        }
        
        return small;
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