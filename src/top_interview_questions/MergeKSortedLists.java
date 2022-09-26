package top_interview_questions;

import high_frequency.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode list : lists) {
            queue.offer(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
            temp = temp.next;
        }

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) >>> 1;
        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid+1, end);
        return mergeTwoSortedLists(l1, l2);
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;

        return dummy.next;
    }
}
