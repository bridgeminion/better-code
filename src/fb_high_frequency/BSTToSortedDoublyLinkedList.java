package fb_high_frequency;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BSTToSortedDoublyLinkedList {
    TreeNode first = null, prev = null;
    public TreeNode treeToDoublyListIterative(TreeNode root) {
        // Write your code here.
        return inOrder(root);
    }

    private TreeNode inOrder(TreeNode root) {
        TreeNode prev = null, temp = root, first = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (prev != null) {
                prev.right = temp;
                temp.left = prev;
            } else {
                first = temp;
            }
            prev = temp;
            temp = temp.right;
        }
        first.left = prev;
        prev.right = first;

        return first;
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        inOrderRecursive(root);
        first.left = prev;
        prev.right = first;

        return first;
    }

    private void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        if (first == null) {
            first = root;
        }
        if (prev != null) {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        inOrderRecursive(root.right);
    }

    public static void main(String[] args) {
        BSTToSortedDoublyLinkedList app = new BSTToSortedDoublyLinkedList();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n4.left = n2;
        n4.right = n5;
        n2.left = n1;
        n2.right = n3;
        System.out.println(app.treeToDoublyList(n4));
    }

}
