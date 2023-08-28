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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        ListNode oddHead=null,oddPtr=null,evenHead=null,evenPtr=null;
        ListNode curr = head,temp=null;
        int pos=1;
        while(curr!=null){
            temp =curr;
            curr=curr.next;
            temp.next=null;
            if(pos%2!=0){
                if(oddHead==null){
                    oddHead=temp;
                    oddPtr=temp;
                }else{
                    oddPtr.next=temp;
                    oddPtr=oddPtr.next;
                }
            }else{
                if(evenHead==null){
                    evenHead=temp;
                    evenPtr=temp;
                }else{
                    evenPtr.next=temp;
                    evenPtr=evenPtr.next;
                }
            }
            pos++;
        }
        
        oddPtr.next=evenHead;
        
        return oddHead;
    }
}