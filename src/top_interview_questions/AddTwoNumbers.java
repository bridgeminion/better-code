package top_interview_questions;

import high_frequency.ListNode;

/**
 * 1. loop condition: l1 != null || l2 != null
 * 2. don't forget add last node if carry > 0
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode temp = sum;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int s = (val1 + val2  + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode node = new ListNode(s);
            temp.next = node;
            temp = temp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            temp.next = node;
        }

        return sum.next;
    }
}
