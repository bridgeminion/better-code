package high_frequency.linked_list;

import high_frequency.ListNode;

/**
 * if there is common node, it will hit within two iteration
 * if not, both tmpA and tmpB will be null which will end the loop
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA, tmpB;
        tmpA = headA;
        tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA == null ? headB : tmpA.next;
            tmpB = tmpB == null ? headA : tmpB.next;
        }

        return tmpA;
    }

}
