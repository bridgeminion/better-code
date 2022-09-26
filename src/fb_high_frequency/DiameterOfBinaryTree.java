package fb_high_frequency;

import common.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = helper(root);

        return result[0];
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0], Math.max(right[0], left[1] + right[1]));
        result[1] = Math.max(left[1], right[1]) + 1;

        return result;
    }
}
