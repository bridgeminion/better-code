package google_high_frequency;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        postOrder(root, new HashMap<>(), list);

        return list;
    }

    private String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        if (root == null) {
            return "";
        }
        String s = root.val + "," + postOrder(root.left, map, list) + "," + postOrder(root.right, map, list);
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            list.add(root);
        }

        return s;
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees app = new FindDuplicateSubtrees();
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(11);
        root.left = node2;
        root.right = node4;
        node2.left = node5;
        node4.left = node3;
        System.out.println(app.findDuplicateSubtrees(root));
    }

}
