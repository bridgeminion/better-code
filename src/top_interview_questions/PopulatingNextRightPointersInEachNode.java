package top_interview_questions;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connectIterative(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node prev = null;
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Node node = queue.poll();
                node.next = prev;
                prev = node;
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return root;
    }


    // faster to implement
    public Node connect(Node root) {
        if (root != null) {
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
                root.right.next = root.next != null ? root.next.left : null;
            }
            connect(root.left);
            connect(root.right);
        }

        return root;
    }



}
