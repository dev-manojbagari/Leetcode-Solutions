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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        
        for(ListNode listNode:lists){
            if(listNode!=null)
                pq.offer(listNode);
        }
        
        ListNode preHead = new ListNode();
        ListNode curr = preHead;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next=node;
            curr=curr.next;
            if(node.next!=null)
                pq.offer(node.next);
        }
      
        return preHead.next;
    }
}