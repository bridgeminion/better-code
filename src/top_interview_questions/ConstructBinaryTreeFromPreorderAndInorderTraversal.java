package top_interview_questions;

import common.TreeNode;

import java.util.Arrays;


public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int root = preorder[0];
        int leftEnd = 0;
        while (inorder[leftEnd] != root) {
            leftEnd++;
        }
        TreeNode rootNode = new TreeNode(root);
        // Arrays.copyOfRange same as String subString, left close, right open
        rootNode.left = buildTree(Arrays.copyOfRange(preorder, 1, leftEnd+1), Arrays.copyOfRange(inorder, 0, leftEnd));
        rootNode.right = buildTree(Arrays.copyOfRange(preorder, leftEnd+1, preorder.length), Arrays.copyOfRange(inorder, leftEnd + 1, inorder.length));

        return rootNode;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal instance = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        instance.buildTree(preorder, inorder);
    }

}
