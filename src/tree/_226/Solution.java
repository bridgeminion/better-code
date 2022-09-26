package tree._226;


import common.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    /**
     * avoid directly root.left = helper(root.right) as this will change root.left which will be used in next
     * @param root
     * @return
     */
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = helper(root.right);
        TreeNode right = helper(root.left);
        root.left = left;
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
