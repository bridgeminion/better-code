package high_frequency.linked_list;

import high_frequency.ListNode;

public class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (prev.next == curr) { // if curr has been updated
                prev = curr;
            } else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
