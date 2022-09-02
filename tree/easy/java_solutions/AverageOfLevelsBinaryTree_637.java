package tree.easy.java_solutions;

import java.util.*;
import java.util.stream.Collectors;

import static tree.Helper.TreeNode;

public class AverageOfLevelsBinaryTree_637 {

    private static class SolutionDFS {

        private static class Pair {
            double sum;
            int nodes;

            public Pair(double sum, int nodes) {
                this.sum = sum;
                this.nodes = nodes;
            }
        }

        public List<Double> averageOfLevels(TreeNode root) {
            Map<Integer, Pair> levelMap = new HashMap<>();

            average(root, 1, levelMap);

            return levelMap.values().stream().map(p -> p.sum / p.nodes).collect(Collectors.toList());
        }

        private void average(TreeNode node, int level, Map<Integer, Pair> levelMap) {
            if (node == null) return;
            levelMap.putIfAbsent(level, new Pair(0, 0));
            levelMap.get(level).nodes += 1;
            levelMap.get(level).sum += node.val;
            average(node.left, level + 1, levelMap);
            average(node.right, level + 1, levelMap);
        }
    }

    private static class SolutionBFS {
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Double> result = new ArrayList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();

                Double average = null;
                int nodesAtLevel = 0;

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();

                    if (node == null) {
                        continue;
                    }
                    if (average == null) {
                        average = 0.0;
                    }
                    average += node.val;
                    nodesAtLevel++;
                    queue.add(node.left);
                    queue.add(node.right);
                }
                if (average != null) {
                    result.add(average / nodesAtLevel);
                }
            }
            return result;
        }
    }
}
