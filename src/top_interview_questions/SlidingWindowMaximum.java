package top_interview_questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for (int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }
        for (int i=0; i<=nums.length-k; i++) {
            max[i] = pq.peek();
            if (i+k == nums.length) {
                break;
            }
            pq.offer(nums[i+k]);
            pq.remove(nums[i]);
        }

        return max;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        TreeSet<Integer> set = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[b], nums[a]) : b - a);
        for (int i=0; i<k; i++) {
            set.add(i);
        }
        for (int i=0; i<=nums.length-k; i++) {
            max[i] = nums[set.first()];
            if (i+k == nums.length) {
                break;
            }
            set.add(i+k);
            set.remove(i);
        }

        return max;
    }

    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum instance = new SlidingWindowMaximum();
        int[] nums = {-7,-8,7,5,7,1,6,0};
        System.out.println(instance.maxSlidingWindow2(nums, 4));
    }
}
