package high_frequency.linked_list;

import high_frequency.ListNode;

import java.util.PriorityQueue;

/**
 * don't forget to add node.next into queue
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            queue.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tmp.next = node;
            tmp = tmp.next;
            if (node != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }

    public ListNode mergeKListsRecursive(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start < end) {
            int mid = (start+end)/2;
            ListNode l1 = merge(lists, start, mid);
            ListNode l2 = merge(lists, mid+1, end);
            return mergeTwoLists(l1, l2);
        }

        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;

        return dummy.next;
    }



}
