package tree._235;

import common.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // means root val is between p and q, don't forget == case
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        }
        return root.val < p.val ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
    }
}
