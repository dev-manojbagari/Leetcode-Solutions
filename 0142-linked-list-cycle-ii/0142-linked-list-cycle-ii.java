public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return cycleHead(slow, head);
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return null;
    }

    ListNode cycleHead(ListNode meet, ListNode head){
        while (head != meet.next) {
            head = head.next;
            meet = meet.next;
        }

        return head;
    }
}
