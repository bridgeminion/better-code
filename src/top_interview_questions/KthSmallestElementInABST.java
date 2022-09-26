package top_interview_questions;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestElementInABST {
    int count = 0;
    int result = 0;
    public int kthSmallestRecursive(TreeNode root, int k) {
        count = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        count--;
        if (count == 0) {
            result = root.val;
        }
        helper(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right; // only push into stack in while loop, here just update curr to curr.right
        }

        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        root.left = t3;
        root.right = t6;
        t3.left = t2;
        t3.right = t4;
        t2.left = t1;
        KthSmallestElementInABST instance = new KthSmallestElementInABST();
        System.out.println(instance.kthSmallest(root, 3));

    }

}
