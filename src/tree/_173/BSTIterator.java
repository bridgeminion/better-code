package tree._173;

import common.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 *
 *
 * Example:
 *
 *
 *
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 */
public class BSTIterator {
    private TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return the next smallest number */
    public int next() {
        return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return true;
    }
}

