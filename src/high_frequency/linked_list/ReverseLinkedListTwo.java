package high_frequency.linked_list;

import high_frequency.ListNode;

/**
 * 1. use dummy to simply
 * 2. just need one extra node (node before reverse)
 */
public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev, curr, next, prevR;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        curr = head;
        prev = dummy;
        int i=1;
        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        prevR = prev;
        while (i <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        prevR.next.next = curr;
        prevR.next = prev;

        return dummy.next;
    }
}
