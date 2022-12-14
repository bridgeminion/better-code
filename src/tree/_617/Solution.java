package tree._617;

import common.TreeNode;

/**
 * 617. Merge Two Binary Trees
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        TreeNode created = new TreeNode(t1.val + t2.val);
        created.left = mergeTrees(t1.left, t2.left);
        created.right = mergeTrees(t1.right, t2.right);

        return created;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root1 = new TreeNode(3);
        TreeNode node1 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        root1.left = node1;
        node1.right = node3;
        TreeNode root2 = new TreeNode(1);
        TreeNode node2 = new TreeNode(5);
        root2.right = node2;
        TreeNode result = solution.mergeTrees(root1, root2);
        System.out.println(result);
    }

}
