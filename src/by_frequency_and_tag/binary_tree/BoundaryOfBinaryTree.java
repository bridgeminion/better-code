package by_frequency_and_tag.binary_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        getLeft(root.left, result);
        getLeaf(root.left, result);
        getLeaf(root.right, result);
        getRight(root.right, result);

        return result;
    }

    private void getLeft(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            result.add(root.val);
            getLeft(root.left, result);
        } else if (root.right != null) {
            result.add(root.val);
            getLeft(root.right, result);
        }
    }

    private void getLeaf(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
        } else {
            getLeaf(root.left, result);
            getLeaf(root.right, result);
        }
    }

    private void getRight(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            getRight(root.right, result);
            result.add(root.val);
        } else if (root.left != null) {
            getRight(root.left, result);
            result.add(root.val);
        }
    }
}
