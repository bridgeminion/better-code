package by_frequency_and_tag.binary_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestBinarySearchTreeValueTwo {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Double.compare(Math.abs(target-a), Math.abs(target-b)));
        List<Integer> result = new ArrayList<>();
        helper(root, k, queue);

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }

    private void helper(TreeNode root, int k, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.offer(root.val);
        if (queue.size() > k) {
            queue.poll();
        }
        helper(root.left, k, queue);
        helper(root.right, k, queue);
    }
}
