package fb_high_frequency;

import common.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        queue.offer(root);
        columnQueue.offer(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int column = columnQueue.poll();
            map.putIfAbsent(column, new ArrayList<>());
            map.get(column).add(node);
            if (node.left != null) {
                queue.offer(node.left);
                columnQueue.offer(column - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                columnQueue.offer(column + 1);
            }
        }
        List<Integer> columns = new ArrayList<>(map.keySet());
        Collections.sort(columns);
        for (int column : columns) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : map.get(column)) {
                list.add(node.val);
            }
            result.add(list);
        }

        return result;
    }
}
