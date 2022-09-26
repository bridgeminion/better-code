package tree._297;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CodecBFS {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#").append(",");
                continue;
            } else {
                sb.append(node.val).append(",");
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] a = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(a[0]));
        queue.add(root);
        for (int i=1; i<a.length; i++) {
            TreeNode node = queue.poll();
            if (!a[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.valueOf(a[i]));
                node.left = left;
                queue.add(left);
            }
            if (!a[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.valueOf(a[i]));
                node.right =  right;
                queue.add(right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        CodecBFS codec = new CodecBFS();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(22);
        TreeNode node3 = new TreeNode(21);
        TreeNode node4 = new TreeNode(32);
        TreeNode node5 = new TreeNode(26);
        TreeNode node6 = new TreeNode(28);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.left = node5;
        node4.left = node6;
        String serialization = codec.serialize(root);
        TreeNode result = codec.deserialize(serialization);

    }

}
