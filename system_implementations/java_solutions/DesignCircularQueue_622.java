package system_implementations.java_solutions;

public class DesignCircularQueue_622 {

    static class CircularQueue {

        private static class Node {
            int val;
            Node next;
            Node prev;

            Node(int val) {
                this.val = val;
            }
        }

        private final Node head;
        private final Node tail;
        private final int queueSize;
        private int currentSize;

        public CircularQueue(int k) {
            this.queueSize = k;
            this.currentSize = 0;
            this.head = new Node(-1);
            this.tail = new Node(-1);
            this.tail.prev = this.head;
            this.head.next = this.tail;
        }

        public boolean enqueue(int value) {
            if (isFull()) {
                return false;
            }
            Node node = new Node(value);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            currentSize++;
            return true;
        }

        public boolean dequeue() {
            if (isEmpty()) {
                return false;
            }
            Node toDelete = head.next;
            head.next = toDelete.next;
            toDelete.next.prev = head;
            toDelete.next = null;
            toDelete.prev = null;
            currentSize--;
            return true;
        }

        public int front() {
            if (isEmpty()) return -1;
            return head.next.val;
        }

        public int rear() {
            if (isEmpty()) return -1;
            return tail.prev.val;
        }

        public boolean isEmpty() {
            return currentSize == 0;
        }

        public boolean isFull() {
            return currentSize == queueSize;
        }
    }
}
