```
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
ListNode mid = getMid(head);
ListNode midNext = mid.next;