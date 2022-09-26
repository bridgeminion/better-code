package google_high_frequency;

import high_frequency.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LinkedListComponents {
    public int numComponentsOriginal(ListNode head, int[] nums) {
        ListNode temp = head;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int count = 0, sum = 0;
        while (temp != null) {
            if (set.contains(temp.val)) {
                count++;
            } else {
                if (count > 0) {
                    sum++;
                    count = 0;
                }
            }
            temp = temp.next;
        }
        if (count > 0) {
            sum++;
        }

        return sum;
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int sum = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                sum++;
            }
            head = head.next;
        }

        return sum;
    }

}
