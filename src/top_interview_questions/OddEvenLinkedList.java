package top_interview_questions;

import high_frequency.ListNode;

/**
 * Use fast slow to track odd/even, get first even node first
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList1(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode tail = dummy, temp = dummy, prev;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        if (count <= 2) {
            return dummy.next;
        }
        int index = 0;
        while (index < count) {
            prev = temp;
            temp = temp.next;
            index++;
            if (index % 2 == 0) {
                prev.next = temp.next;
                tail.next = temp;
                tail = tail.next;
            }
            System.out.println("aa");
        }

        tail.next = null;
        return dummy.next;
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode fast = head.next, slow = head;
        ListNode even = head.next;
        while (fast != null && fast.next != null) {
            slow.next = slow.next.next;
            fast.next = fast.next.next;
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = even;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        OddEvenLinkedList instance = new OddEvenLinkedList();
        instance.oddEvenList(head);
    }

}
