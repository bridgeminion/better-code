package high_frequency.linked_list;

import high_frequency.ListNode;

/**
 * 1. use fast as end loop condition, if no cycle this will end the loop
 * 2. if fast meets slow, must be cycle
 * 3. once meet, set either fast or slow to head
 */
public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
    }

}
