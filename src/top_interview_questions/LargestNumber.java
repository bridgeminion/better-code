package top_interview_questions;

import java.util.PriorityQueue;

/**
 * compare two number with lexical order, use this comparator
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        // Comparator
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
            String s1 = n1.toString() + n2.toString();
            String s2 = n2.toString() + n1.toString();
            return s2.compareTo(s1);
        }
        );
        for (int num : nums) {
            queue.offer(num);
        }
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }

        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        LargestNumber instance = new LargestNumber();
        int[] nums = {3,30,34,5,9};
        System.out.println(instance.largestNumber(nums));
    }

}
