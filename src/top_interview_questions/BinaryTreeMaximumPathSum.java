package top_interview_questions;

import common.TreeNode;

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);

        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;
        int sum = left + right + root.val;
        max = Math.max(max, sum);

        return Math.max(left, right) + root.val;
    }

}
