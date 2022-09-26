package high_frequency.linked_list;

import high_frequency.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr, next;
        curr = head;
        next = head;
        while (next != null) {
            while (next.next != null && next.next.val == curr.val) {
                next = next.next;
            }
            curr.next = next.next;
            curr = curr.next;
            next = curr;
        }

        return head;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;
    }


}
