package fb_high_frequency;

import common.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        Map<TreeNode, Integer> map = new HashMap<>();
//        findPath(root, target, map);
//        dfs(root, map, result, k);
//
//        return result;
//    }
//
//    private int findPath(TreeNode root, TreeNode target, Map<TreeNode, Integer> map) {
//        if (root == null) {
//            return -1;
//        }
//        if (root.val == target.val) {
//            map.put(root, 0);
//            return 0;
//        }
//        int left = findPath(root.left, target, map);
//        if (left >= 0) {
//            map.put(root, left + 1);
//            return left + 1;
//        }
//        int right = findPath(root.right, target, map);
//        if (right >= 0) {
//            map.put(root, right + 1);
//            return right + 1;
//        }
//
//        return -1;
//    }
//
//    private void dfs(TreeNode root, Map<TreeNode, Integer> map, List<Integer> result, int k) {
//        if (root == null) {
//            return;
//        }
//        if (map.getOrDefault(root, 0) == k) {
//            result.add(root.val);
//        }
//        dfs(root.left, map, result, k);
//        dfs(root.right, map, result, k);
//    }

    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.left = node5;
        node4.right = node6;
        AllNodesDistanceKInBinaryTree app = new AllNodesDistanceKInBinaryTree();
        app.distanceK(node1, node2, 1);

    }
}
