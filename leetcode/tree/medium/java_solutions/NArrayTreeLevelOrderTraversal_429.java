package leetcode.tree.medium.java_solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static leetcode.tree.Helper.Node;

public class NArrayTreeLevelOrderTraversal_429 {

    private static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            traverse(root, 1, map);
            return new ArrayList<>(map.values());
        }

        private void traverse(Node root, int level, Map<Integer, List<Integer>> map) {
            if (root == null) return;
            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(root.val);
            for (Node n : root.children) {
                traverse(n, level + 1, map);
            }
        }
    }
}
