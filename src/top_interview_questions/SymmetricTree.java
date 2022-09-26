package top_interview_questions;

import common.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);

    }

    private boolean helper(TreeNode left, TreeNode right) {
        // check if both null, otherwise return false
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }

}
