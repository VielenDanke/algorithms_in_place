package tree.easy.java_solutions;

import tree.Helper;

import java.util.ArrayList;
import java.util.List;

import static tree.Helper.*;

public class NaryTreePreorderTraversal_589 {

    private static class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> values = new ArrayList<>();
            dfs(values, root);
            return values;
        }

        private void dfs(List<Integer> values, Node root) {
            if (root == null) return;
            values.add(root.val);
            for (Node node : root.children) dfs(values, node);
        }
    }
}
