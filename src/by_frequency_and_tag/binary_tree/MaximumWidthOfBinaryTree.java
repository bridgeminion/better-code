package by_frequency_and_tag.binary_tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    class Entry {
        TreeNode node;
        int index;
        public Entry (TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(new Entry(root, 1));
        int left = 0, right = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size; i++) {
                Entry entry = queue.poll();
                int index = entry.index;
                TreeNode node = entry.node;
                if (i == 0) {
                    left = index;
                }
                if (i == size - 1) {
                    right = index;
                }
                if (node.left != null) {
                    queue.offer(new Entry(node.left, index * 2));
                }
                if (node.right != null) {
                    queue.offer(new Entry(node.right, index * 2 + 1));
                }
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }


}
