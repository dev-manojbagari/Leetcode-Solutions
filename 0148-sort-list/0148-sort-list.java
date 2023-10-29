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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        return mergeSort(head);
    }
    
    ListNode mergeSort(ListNode head){
        if(head==null||head.next==null)
            return head;
        
        ListNode mid= getMid(head);
        ListNode midNext=mid.next;
        mid.next=null;
        ListNode left=mergeSort(head);
        ListNode right=mergeSort(midNext);
        
        return sortedMerge(left,right);
    }
    
      public ListNode sortedMerge(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead,tempNode=null;
        
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                tempNode = list1;
                list1=list1.next;
            }else{
                tempNode = list2;
                list2=list2.next;
            }
            curr.next=tempNode;
            curr=curr.next;
        }
        
        if(list1!=null)
            curr.next=list1;
        else if(list2!=null)
            curr.next=list2;
        
        return preHead.next;
    }
    
    
    ListNode getMid(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        
        if(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
    
}