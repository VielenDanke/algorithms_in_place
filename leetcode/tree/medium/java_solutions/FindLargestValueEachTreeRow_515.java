package leetcode.tree.medium.java_solutions;

import java.util.*;

import static leetcode.tree.Helper.TreeNode;

public class FindLargestValueEachTreeRow_515 {

    static class SolutionDFS {
        private Map<Integer, Integer> map;

        public List<Integer> largestValues(TreeNode root) {
            map = new HashMap<>();

            int startLevel = 1;

            dfs(root, startLevel);

            List<Integer> result = new LinkedList<>();

            while (map.containsKey(startLevel)) {
                result.add(map.get(startLevel++));
            }
            return result;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) return;
            if (map.containsKey(level)) {
                map.put(level, Math.max(map.get(level), root.val));
            } else {
                map.put(level, root.val);
            }
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }

    static class SolutionBFS {
        public List<Integer> largestValues(TreeNode root) {
            /*
            Idea:
            1. BFS traversal
            2. On each level find max value
            3. Add to result list
            */
            List<Integer> result = new LinkedList<>();

            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                int currentSize = queue.size();

                Integer currentMax = null;

                for (int i = 0; i < currentSize; i++) {
                    TreeNode node = queue.poll();

                    if (node == null) continue;

                    currentMax = currentMax == null ? node.val : Math.max(currentMax, node.val);

                    queue.add(node.left);
                    queue.add(node.right);
                }
                if (currentMax != null) {
                    result.add(currentMax);
                }
            }
            return result;
        }
    }
}
