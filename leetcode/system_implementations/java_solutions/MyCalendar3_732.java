package leetcode.system_implementations.java_solutions;

public class MyCalendar3_732 {

    static class MyCalendarThree {

        public MyCalendarThree() {
            root = new TreeNode(0, 1000000000);
        }

        public int book(int start, int end) {
            add(root, start, end, 1);
            return getMax(root);
        }

        private static class TreeNode {
            int start;
            int end;
            TreeNode left = null;
            TreeNode right = null;
            int booked = 0;
            int saved = 0;

            public TreeNode(int s, int t) {
                this.start = s;
                this.end = t;
            }
        }

        private final TreeNode root;

        private void add(TreeNode node, int start, int end, int val) {
            if (node == null || start >= node.end || end < node.start) return;
            if (start <= node.start && node.end <= end) {
                node.booked += val;
                node.saved += val;
                return;
            }
            int mid = node.start + (node.end - node.start) / 2;
            if (overlap(node.start, mid, start, end)) {
                if (node.left == null) node.left = new TreeNode(node.start, mid);
                add(node.left, start, end, val);
            }

            if (overlap(mid, node.end, start, end)) {
                if (node.right == null) node.right = new TreeNode(mid, node.end);
                add(node.right, start, end, val);
            }
            node.saved = node.booked + Math.max(getMax(node.left), getMax(node.right));
        }

        private int getMax(TreeNode node) {
            if (node == null) return 0;
            return node.saved;
        }

        private boolean overlap(int s, int e, int l, int r) {
            return r > s && l < e;
        }
    }
}
