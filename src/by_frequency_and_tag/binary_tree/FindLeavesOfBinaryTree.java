package by_frequency_and_tag.binary_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private int helper(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        int height = Math.max(helper(root.left, result), helper(root.right, result)) + 1;
        if (result.size() < height) {
            result.add(new ArrayList<>());
        }
        result.get(height - 1).add(root.val);

        return height;
    }

}
