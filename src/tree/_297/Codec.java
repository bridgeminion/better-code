package tree._297;

import common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);

        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return recurse(queue);
    }

    private TreeNode recurse(Queue<String> queue) {
        String token = queue.poll();
        if ("#".equals(token)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(token));
        node.left = recurse(queue);
        node.right = recurse(queue);

        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(15);
        TreeNode node1 = new TreeNode(12);
        TreeNode node2 = new TreeNode(122);
        TreeNode node3 = new TreeNode(121);
        TreeNode node4 = new TreeNode(132);
        TreeNode node5 = new TreeNode(1126);
        TreeNode node6 = new TreeNode(282);
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
