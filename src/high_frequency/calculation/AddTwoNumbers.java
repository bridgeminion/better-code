package high_frequency.calculation;

import high_frequency.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int resultVal = val1 + val2 + carry;
            temp.next = new ListNode(resultVal % 10);
            carry = resultVal/10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            temp = temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers instance = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        ListNode result = instance.addTwoNumbers(l1, l4);
    }

}
