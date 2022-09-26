package fb_high_frequency;

import high_frequency.Node;

public class InsertIntoSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if(head==null) {
            head = new Node(insertVal);
            head.next = head;
        } else {
            Node curNode = head;
            while(!(insertVal<=curNode.next.val && insertVal>=curNode.val) &&
                    !(curNode.val>curNode.next.val && (insertVal>=curNode.val||insertVal<=curNode.next.val)) &&
                    curNode.next!=head) {
                curNode = curNode.next;
            }
            Node tmp = curNode.next;
            curNode.next = new Node(insertVal);
            curNode.next.next = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        Node node1 = new Node(3);
        Node node2 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = head;
        InsertIntoSortedCircularLinkedList app = new InsertIntoSortedCircularLinkedList();
        app.insert(head, 7);
    }
}
