package google_high_frequency;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left != null || root.right != null) {
            result.add(root.val);
        }
        leftBoundary(root.left, result);
        leaf(root, result);
        rightBoundary(root.right, result);

        return result;
    }

    private void rightBoundary(TreeNode root, List<Integer> result) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        if (root.right != null) {
            rightBoundary(root.right, result);
        } else {
            rightBoundary(root.left, result);
        }
        result.add(root.val);
    }

    private void leaf(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
        leaf(root.left, result);
        leaf(root.right, result);
    }

    private void leftBoundary(TreeNode root, List<Integer> result) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            leftBoundary(root.left, result);
        } else {
            leftBoundary(root.right, result);
        }
    }
}
