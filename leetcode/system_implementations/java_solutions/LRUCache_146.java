package leetcode.system_implementations.java_solutions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

    static class LRUCache {

        private static class Node {
            Node prev, next;
            int key, value;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final Node head = new Node(0, 0);
        private final Node tail = new Node(0, 0);
        private final Map<Integer, Node> storage = new HashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            if (storage.containsKey(key)) {
                Node node = storage.get(key);
                remove(node);
                insert(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (storage.containsKey(key)) {
                remove(storage.get(key));
            }
            if (storage.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(key, value));
        }

        private void remove(Node node) {
            storage.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            storage.put(node.key, node);
            Node headNext = head.next;
            head.next = node;
            node.prev = head;
            headNext.prev = node;
            node.next = headNext;
        }
    }
}
