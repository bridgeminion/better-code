package top_interview_questions;

import common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Use preorder traverse
 */
public class SerializeAndDeserializeBinaryTree {
    private static final String NULL = "X";
    private static final String SPLITTER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);

        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLITTER);
        } else {
            sb.append(root.val).append(SPLITTER);
            helper(root.left, sb);
            helper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList(Arrays.asList(data.split(SPLITTER)));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Deque<String> queue) {
        String str = queue.poll();
        if (str.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }
}
