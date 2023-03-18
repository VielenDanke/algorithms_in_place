package leetcode.system_implementations.java_solutions;

import java.util.Stack;

public class DesignBrowserHistory_1472 {

    static class BrowserHistoryStack {

        private final Stack<String> history = new Stack<>();
        private final Stack<String> future = new Stack<>();

        public BrowserHistoryStack(String homepage) {
            history.add(homepage);
        }

        public void visit(String url) {
            history.add(url);
            future.clear();
        }

        public String back(int steps) {
            while (steps > 0 && history.size() > 1) {
                future.add(history.pop());
                steps--;
            }
            return history.peek();
        }

        public String forward(int steps) {
            while (steps > 0 && future.size() > 0) {
                history.add(future.pop());
                steps--;
            }
            return history.peek();
        }
    }


    static class BrowserHistory {

        private static class Node {
            private final String url;
            private Node prev;
            private Node next;

            private Node(String url) {
                this.url = url;
            }
        }

        private Node current;

        public BrowserHistory(String homepage) {
            current = new Node(homepage);
        }

        public void visit(String url) {
            Node node = new Node(url);
            current.next = node;
            node.prev = current;
            current = current.next;
        }

        public String back(int steps) {
            while (current.prev != null && steps-- > 0) {
                current = current.prev;
            }
            return current.url;
        }

        public String forward(int steps) {
            while (current.next != null && steps-- > 0) {
                current = current.next;
            }
            return current.url;
        }
    }
}
