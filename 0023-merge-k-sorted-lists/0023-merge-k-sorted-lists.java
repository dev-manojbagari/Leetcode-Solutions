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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode listNode:lists){
            if(listNode!=null)
                pq.offer(listNode);
        }
        
        while(!pq.isEmpty()){
            ListNode listNode = pq.poll();
            curr.next = listNode;
            curr=curr.next;
            if(listNode.next!=null)
                pq.offer(listNode.next);
        }
        
        return preHead.next;
    }
}