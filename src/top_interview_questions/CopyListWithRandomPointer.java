package top_interview_questions;

import high_frequency.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            entry.getValue().next = map.get(entry.getKey().next); // not just entry.getKey().next which points to original node
            entry.getValue().random = map.get(entry.getKey().random);
        }

        return map.get(head);
    }
}
