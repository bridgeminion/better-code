package by_frequency_and_tag.binary_tree;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrderTraversal {
    class Pair {
        TreeNode node;
        int index;

        public Pair (TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            map.putIfAbsent(pair.index, new ArrayList<>());
            map.get(pair.index).add(node.val);
            if (node.left != null) {
                queue.offer(new Pair(node.left, pair.index - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, pair.index + 1));
            }
        }
        return new ArrayList<>(map.values());
    }

    public List<List<Integer>> verticalOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        helper(root, map, 0, 0);

        for (TreeMap<Integer, List<Integer>> value : map.values()) {
            List<Integer> l = new ArrayList<>();
            for (List<Integer> list : value.values()) {
                l.addAll(list);
            }
            result.add(l);
        }

        return result;
    }

    private void helper(TreeNode root, Map<Integer, TreeMap<Integer, List<Integer>>> map, int index, int depth) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(index, new TreeMap<>());
        map.get(index).putIfAbsent(depth, new ArrayList<>());
        map.get(index).get(depth).add(root.val);
        helper(root.left, map, index - 1, depth+1);
        helper(root.right, map, index + 1, depth+1);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node3.left = node9;
        node3.right = node8;
        node9.left = node4;
        node9.right = node0;
        node8.left = node1;
        node8.right = node7;
        node0.right = node2;
        node1.left = node5;
        BinaryTreeVerticalOrderTraversal app = new BinaryTreeVerticalOrderTraversal();
        app.verticalOrder(node3);
    }

}
