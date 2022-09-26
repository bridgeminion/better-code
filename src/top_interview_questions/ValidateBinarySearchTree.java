package top_interview_questions;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {
    public boolean isValidBST1(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null) {
            return true;
        }
        if (minValue != null && root.val <= minValue || maxValue != null &&  root.val >= maxValue) {
            return false;
        }
        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && prev.val >= curr.val) {
                return false;
            }
            prev = curr;
            curr = curr.right;
        }

        return true;
    }

}
