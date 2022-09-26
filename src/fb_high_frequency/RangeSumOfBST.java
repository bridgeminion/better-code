package fb_high_frequency;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBSTWithGlobal(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        rangeSumBSTWithGlobal(root.left, low, high);
        rangeSumBSTWithGlobal(root.right, low, high);

        return sum;
    }

    public int rangeSumBSTRecursive(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        return (root.val >= low && root.val <= high ? root.val : 0) + rangeSumBSTRecursive(root.left, low, high) + rangeSumBSTRecursive(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        TreeNode temp = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            if (temp.val >= low && temp.val <= high) {
                sum += temp.val;
            }
            temp = temp.right;
        }

        return sum;
    }

}
