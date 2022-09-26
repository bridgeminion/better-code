package google_high_frequency;

import common.TreeNode;

public class BinaryTreeLongestConsecutiveSequenceTwo {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        int[] r = helper(root);
        return max;
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int leftInc = 0, leftDec = 0, rightInc = 0, rightDec = 0;
        if (root.left != null) {
            int[] left = helper(root.left);
            if (root.left.val + 1 == root.val) {
                leftDec = left[0];
            } else if (root.left.val - 1 == root.val) {
                leftInc = left[1];
            }
        }
        if (root.right != null) {
            int[] right = helper(root.right);
            if (root.right.val - 1 == root.val) {
                rightInc = right[1];
            } else if (root.right.val + 1 == root.val) {
                rightDec = right[0];
            }
        }
        max = Math.max(max, Math.max(leftInc+rightDec, leftDec+rightInc) + 1);
        System.out.println("max=" + max + ", root="+root.val + ", left=" + (Math.max(leftInc, rightInc)+1) + ", right=" + (Math.max(leftDec, rightDec)+1));
        return new int[]{Math.max(leftDec, rightDec)+1, Math.max(leftInc, rightInc)+1};
    }

    public static void main(String[] args) {
        BinaryTreeLongestConsecutiveSequenceTwo app = new BinaryTreeLongestConsecutiveSequenceTwo();
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        node1.left = node2;
//        node2.left = node3;
//        node3.left = node4;
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node2.right = node3;
        System.out.println(app.longestConsecutive(node1));
    }

}
