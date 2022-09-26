package by_frequency_and_tag;

import common.TreeNode;

public class PathSumThree {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int helper(TreeNode root, int targetSum) {
        int result = 0;
        if (root == null) {
            return result;
        }
        if (root.val == targetSum) {
            result++;
        }
        result += helper(root.left, targetSum - root.val);
        result += helper(root.right, targetSum - root.val);

        return result;
    }
}
