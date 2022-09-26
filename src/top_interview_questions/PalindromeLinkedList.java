package top_interview_questions;

import high_frequency.ListNode;

// due to recursion nature, ref will compare to last element, then ref=ref.next
public class PalindromeLinkedList {
    ListNode ref;
    public boolean isPalindrome(ListNode head) {
        ref = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean equal = check(head.next);
        boolean b = ref.val == head.val;
        ref = ref.next;

        return equal && b;
    }

    public static void main(String[] args) {
        PalindromeLinkedList instance = new PalindromeLinkedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(29);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(instance.isPalindrome(a));
    }

}
