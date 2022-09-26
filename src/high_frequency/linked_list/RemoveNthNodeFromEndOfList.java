package high_frequency.linked_list;

import high_frequency.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy, prev, fast;
        dummy = new ListNode(0);
        dummy.next = head;
        prev = dummy;
        fast = head;
        for (int i=1; i<n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            prev = prev.next;
            fast = fast.next;

        }
        prev.next = prev.next.next;

        return dummy;
    }

}
