package leetcode.tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static leetcode.tree.Helper.*;

public class BSTIterator_173 {

    private static class BSTIterator {

        private final Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            dfs(list, root);
            this.iterator = list.iterator();
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        private void dfs(List<Integer> list, TreeNode node) {
            if (node == null) return;
            dfs(list, node.left);
            list.add(node.val);
            dfs(list, node.right);
        }
    }
}
