package top_interview_questions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DoubleNode {
        DoubleNode prev;
        DoubleNode next;
        int key; // need key in Double Node to remove from map
        int val;
        public DoubleNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Map<Integer, DoubleNode> map;
    DoubleNode head;
    DoubleNode tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoubleNode(0, 0);
        tail = new DoubleNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        return -1;
    }

    private void moveToHead(DoubleNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DoubleNode node) {
        head.next.prev = node;
        node.prev = head;
        node.next = head.next;
        head.next = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                DoubleNode oldest = tail.prev;
                removeNode(oldest);
                map.remove(oldest.key);
            }
            DoubleNode node = new DoubleNode(key, value);
            addToHead(node);
            map.put(key, node);
        }
    }

    public static void main(String[] args) {
        LRUCache instance = new LRUCache(2);
        instance.put(2, 1);
        instance.put(1, 1);
        instance.put(2, 3);
        instance.put(4, 1);
        System.out.println(instance.get(1));
        System.out.println(instance.get(2));
    }
}
